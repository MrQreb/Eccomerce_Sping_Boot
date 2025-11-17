package com.modular.modules.Usuario.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modular.modules.Usuario.Entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{

};
