package com.modular.modules.Categoria;

import org.springframework.stereotype.Service;

import com.modular.modules.Categoria.Entity.CategoriaEntity;
import com.modular.modules.Categoria.Repository.CategoriaRepository;

import java.util.List;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    };

    public void createCategoria(String nombre){
        CategoriaEntity nuevaCategoria = new CategoriaEntity();
        nuevaCategoria.setNombre(nombre);
        categoriaRepository.save(nuevaCategoria);
        System.out.println("Categoria creada");
    }

    public List<CategoriaEntity> getCategoria(){
        return categoriaRepository.findAll();
    }

    public List<CategoriaEntity> getCategorias(){
     return  categoriaRepository.findAll();
    }
}
