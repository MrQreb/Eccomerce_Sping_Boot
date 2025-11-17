package com.modular.modules.Categoria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modular.modules.Categoria.Entity.CategoriaEntity;



public interface CategoriaRepository extends JpaRepository <CategoriaEntity, Long> {
}

