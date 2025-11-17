package com.modular.modules.Usuario;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.modular.modules.Usuario.Entity.UsuarioEntity;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new UsuarioEntity());
        return "formularioUsuario";
    }

    @PostMapping("/crear")
    public String createUsuario(UsuarioEntity usuario, RedirectAttributes redirectAttributes) {
        try {
            usuarioService.createUsuarioNormal(usuario);
            redirectAttributes.addFlashAttribute("exito", "¡Usuario registrado con éxito!");
            return "redirect:/usuario/formulario";
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/usuario/formulario";
        }
    }
    

    @GetMapping("/login")
    public String mostrarLoginFormulario() {
        return "login";
    }

    @GetMapping("/home")
    public String mostrarHome() {
        return "home";
    }

    @PostMapping("/login")
    public String login(@RequestParam String usuario, @RequestParam String contrasena, Model model) {
        try {
            usuarioService.login(usuario, contrasena);
            return "redirect:/usuario/home";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "login";
        }
    }
}
