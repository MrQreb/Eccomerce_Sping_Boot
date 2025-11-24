package com.modular.modules.Categoria;

import com.modular.modules.Categoria.Entity.CategoriaEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    @GetMapping("/crear")
    public String mostrarCrear(Model model){
        model.addAttribute("categoriaCategoria", new CategoriaEntity());
        return "categoria/crearCategoria";
    }

    @PostMapping("/crear")
    public String crearCategoria(@RequestParam("categoria") String categoria, Model model) {
        try {
            categoriaService.createCategoria(categoria);
            return "redirect:/categoria/crear?exito=true";
        } catch (Exception e) {
            model.addAttribute("error", "Hubo un error al crear la categoría");
            return "categoria/crear-categoria-form";
        }
    }


}
