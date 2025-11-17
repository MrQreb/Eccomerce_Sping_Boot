package com.modular.modules.Categoria;

import org.springframework.stereotype.Service;

import com.modular.modules.Categoria.Entity.CategoriaEntity;
import com.modular.modules.Categoria.Repository.CategoriaRepository;
@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    };

    public void createCategoria(CategoriaEntity categoria){
        CategoriaEntity nuevaCategoria = new CategoriaEntity();
        nuevaCategoria.setNombre(nuevaCategoria.getNombre());
        categoriaRepository.save(nuevaCategoria);
        System.out.println("CategorIA creada");
        System.out.println("Nombre" + nuevaCategoria.getNombre());
    }
}
