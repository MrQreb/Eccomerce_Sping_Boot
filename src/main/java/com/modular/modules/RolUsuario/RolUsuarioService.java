package com.modular.modules.RolUsuario;

import org.springframework.stereotype.Service;

import com.modular.modules.RolUsuario.Entity.RolUsuarioEntity;
import com.modular.modules.RolUsuario.Repository.RolUsuarioRepository;

@Service
public class RolUsuarioService {

    private final RolUsuarioRepository rolUsuarioRepository;

    //Injeccion de depdencias
    public RolUsuarioService(
            RolUsuarioRepository rolUsuarioRepository
    ) {
        this.rolUsuarioRepository = rolUsuarioRepository;
    };

    public void createRol(RolUsuarioEntity rol) {
        RolUsuarioEntity nuevoRol = new RolUsuarioEntity();
        nuevoRol.setNombre(rol.getNombre());
        rolUsuarioRepository.save(nuevoRol);
        System.out.print("Rol guardo");
    }
;

}
