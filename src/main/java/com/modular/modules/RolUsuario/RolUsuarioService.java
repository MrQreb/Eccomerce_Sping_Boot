package com.modular.modules.RolUsuario;

import java.util.List;

import org.springframework.stereotype.Service;

import com.modular.modules.RolUsuario.Entity.RolUsuarioEntity;
import com.modular.modules.RolUsuario.Repository.RolUsuarioRepository;
import java.util.Optional;

@Service
public class RolUsuarioService {

    private final RolUsuarioRepository rolUsuarioRepository;

    public RolUsuarioService(
            RolUsuarioRepository rolUsuarioRepository
    ) {
        this.rolUsuarioRepository = rolUsuarioRepository;
    }

    ;

    public void createRol(RolUsuarioEntity rol) {
        RolUsuarioEntity nuevoRol = new RolUsuarioEntity();
        nuevoRol.setNombre(rol.getNombre());
        rolUsuarioRepository.save(nuevoRol);
        System.out.print("Rol guardo");
    }

    public List<RolUsuarioEntity> getRoles() {
        return rolUsuarioRepository.findAll();
    }

    public RolUsuarioEntity getAdminRol() {
        Optional<RolUsuarioEntity> rol = rolUsuarioRepository.findByNombre("admin");
        return rol.orElseThrow(() -> new RuntimeException("Rol 'admin' no encontrado"));
    }

    public RolUsuarioEntity getUsuarioRol() {
        Optional<RolUsuarioEntity> rol = rolUsuarioRepository.findByNombre("usuario");
        return rol.orElseThrow(() -> new RuntimeException("Rol 'usuario' no encontrado"));
    }

    public Long getAdminRolId() {
        Optional<RolUsuarioEntity> rol = rolUsuarioRepository.findByNombre("admin");
        return rol.map(RolUsuarioEntity::getId)
                .orElseThrow(() -> new RuntimeException("Rol 'admin' no encontrado"));
    }

    public Long getUsuarioRolId() {
        Optional<RolUsuarioEntity> rol = rolUsuarioRepository.findByNombre("usuario");
        return rol.map(RolUsuarioEntity::getId)
                .orElseThrow(() -> new RuntimeException("Rol 'usuario' no encontrado"));
    }

}
