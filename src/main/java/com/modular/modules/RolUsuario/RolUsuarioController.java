package com.modular.modules.RolUsuario;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modular.modules.RolUsuario.Entity.RolUsuarioEntity;


@RestController
@RequestMapping("rol")
public class RolUsuarioController {
    private final RolUsuarioService rolUsuarioService;

    public RolUsuarioController(RolUsuarioService rolUsuarioService){
        this.rolUsuarioService = rolUsuarioService;
    }

    @PostMapping("crear")
    public void createRol(@RequestBody RolUsuarioEntity rol){
        rolUsuarioService.createRol(rol);
    }

}
