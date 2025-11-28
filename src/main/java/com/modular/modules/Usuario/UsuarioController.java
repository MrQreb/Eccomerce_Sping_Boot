package com.modular.modules.Usuario;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.modular.modules.Usuario.Entity.UsuarioEntity;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    //Crear usuario normal
    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new UsuarioEntity());
        return "usuario/crear-cuenta-form";
    }

    @PostMapping("/crear")
    public String createUsuario(UsuarioEntity usuario, RedirectAttributes redirectAttributes) {
        try {
            usuarioService.createUsuarioNormal(usuario);
            redirectAttributes.addFlashAttribute("exito", "¡Usuario registrado con éxito!");
            return "redirect:/usuario/login";
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/usuario/formulario";
        }
    }

    //Crear usuario admin
    @GetMapping("/admin")
    public String mostrarFormularioAdmin(Model model) {
        model.addAttribute("usuario", new UsuarioEntity());
        return "admin/crear-cuenta-form";
    }

    @PostMapping("/admin/crear")
    public String createUsuarioAdmin(UsuarioEntity usuario, RedirectAttributes redirectAttributes) {
        try {
            usuarioService.createUsuarioAdmin(usuario);
            redirectAttributes.addFlashAttribute("exito", "¡Usuario registrado con éxito!");
            return "redirect:/admin/home";
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/usuario/admin";
        }
    }

    @GetMapping("/login")
    public String mostrarLoginFormulario() {
        return "usuario/login";
    }

    @GetMapping("/home")
    public String mostrarHome() {
        return "usuario/home";
    }

    @PostMapping("/login")
    public String login(@RequestParam String usuario, @RequestParam String contrasena, Model model, HttpSession session) {
        try {
            UsuarioEntity usuarioEntity = usuarioService.login(usuario, contrasena);
            String rol = usuarioEntity.getRol().getNombre();

            session.setAttribute("rolUsuario", rol);

            //Mandar diferetentes paneles en base el rol
            if ("usuario".equalsIgnoreCase(rol)) {
                return "redirect:/usuario/home";
            }
            if ("admin".equalsIgnoreCase(rol)) {
                return "redirect:/admin/home";
            }

            return  "redirect:/usuario/login";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "usuario/login";
        }
    }

}
