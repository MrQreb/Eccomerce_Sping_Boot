package com.modular.modules.RolUsuario;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modular.modules.RolUsuario.Entity.RolUsuarioEntity;

@RestController
@RequestMapping("rol")
public class RolUsuarioController {

    private final RolUsuarioService rolUsuarioService;

    public RolUsuarioController(RolUsuarioService rolUsuarioService) {
        this.rolUsuarioService = rolUsuarioService;
    }

    @GetMapping("ver")
    public List<RolUsuarioEntity> getRoles() {
        return rolUsuarioService.getRoles();
    }

    @PostMapping("crear")
    public void createRol(@RequestBody RolUsuarioEntity rol) {
        rolUsuarioService.createRol(rol);
    }

}
