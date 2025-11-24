package com.modular.modules.Provedor;


import com.modular.modules.Categoria.Entity.CategoriaEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/provedor")
public class ProvedorController {

    private final ProvedorService provedorService;

    public ProvedorController(ProvedorService provedorService) {
        this.provedorService = provedorService;
    }

    @GetMapping("/crear")
    public String mostrarCrear(Model model) {
        model.addAttribute("categoriaCategoria", new CategoriaEntity());
        return "provedor/crear-provedor-form";
    }

    @PostMapping("/crear")
    public String crearCategoria(@RequestParam("provedor") String provedor, Model model) {
        try {
            provedorService.createProvedor(provedor);
            return "redirect:/provedor/crear?exito=true";
        } catch (Exception e) {
            model.addAttribute("error", "Hubo un error al crear la categoría");
            return "provedor/crear-provedor-form";
        }
    }
}
