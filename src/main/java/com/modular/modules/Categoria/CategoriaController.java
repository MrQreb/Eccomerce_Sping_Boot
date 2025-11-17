package com.modular.modules.Categoria;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modular.modules.Categoria.Entity.CategoriaEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("categoria")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }


   @PostMapping("crear")
    public void createCategoria(@RequestBody CategoriaEntity categoria){
        categoriaService.createCategoria(categoria);
    }
}
