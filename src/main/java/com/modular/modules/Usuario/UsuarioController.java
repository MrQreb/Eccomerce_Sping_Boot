package com.modular.modules.Usuario;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modular.modules.Usuario.Entity.UsuarioEntity;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/crear")
    public UsuarioEntity createUsuario(@RequestBody UsuarioEntity usuarioDto) {
        return usuarioService.createUsuario(usuarioDto);
    }
    @PostMapping("/obtener")
    public List<UsuarioEntity> getUsuarios() {
        return usuarioService.getUsuarios();
    }
}
