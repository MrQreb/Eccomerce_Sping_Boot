package com.modular.modules.RolUsuario.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.modular.modules.RolUsuario.Entity.RolUsuarioEntity;

@Repository
public interface RolUsuarioRepository extends JpaRepository<RolUsuarioEntity, Long> {   
}
