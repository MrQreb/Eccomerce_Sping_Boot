package com.modular.modules.Direccion;

import com.modular.modules.Direccion.Entity.DireccionEntity;
import com.modular.modules.Usuario.Entity.UsuarioEntity;
import com.modular.modules.Usuario.Repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/direccion")
public class DireccionController {
    private final DireccionService direccionService;
    private final UsuarioRepository usuarioRepository;

    public DireccionController(DireccionService direccionService, UsuarioRepository usuarioRepository) {
        this.direccionService = direccionService;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/create")
    public String createForm(Model model, HttpSession session) {
        model.addAttribute("direccion", new DireccionEntity());
        Long idUsuario = (Long) session.getAttribute("idUsuario");
        if (idUsuario != null) {
            Optional<UsuarioEntity> u = usuarioRepository.findById(idUsuario);
            u.ifPresent(usuario -> model.addAttribute("usuario", usuario));
        }
        return "direccion/crear-direccion-form";
    }

    @PostMapping("/create")
    public String createSubmit(@ModelAttribute DireccionEntity direccion, HttpSession session) {
        Long idUsuario = (Long) session.getAttribute("idUsuario");
        if (idUsuario == null) {
            return "redirect:/usuario/login";
        }
        Optional<UsuarioEntity> u = usuarioRepository.findById(idUsuario);
        if (u.isEmpty()) {
            return "redirect:/usuario/login";
        }
        direccion.setUsuario(u.get());
        direccionService.createDireccion(direccion);
        return "redirect:/direcciones/mis-direcciones";
    }

    @GetMapping("/usuario/{id}")
    public String listarPorUsuario(@PathVariable Long id, Model model) {
        List<DireccionEntity> direcciones = direccionService.findByUsuarioId(id);
        model.addAttribute("direcciones", direcciones);
        Optional<UsuarioEntity> u = usuarioRepository.findById(id);
        u.ifPresent(usuario -> model.addAttribute("usuario", usuario));
        return "direccion/listar-direcciones-usuario";
    }

    @GetMapping("/mis-direcciones")
    public String listarMisDirecciones(HttpSession session) {
        Long idUsuario = (Long) session.getAttribute("idUsuario");
        if (idUsuario == null) {
            return "redirect:/usuario/login";
        }
        return "redirect:/direccion/usuario/" + idUsuario;
    }
}
