package com.modular.modules.Usuario.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.modular.modules.Usuario.Entity.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    UsuarioEntity findByUsuarioAndContrasena(String usuario, String contrasena);
    Optional<UsuarioEntity> findByCorreo(String correo);
}