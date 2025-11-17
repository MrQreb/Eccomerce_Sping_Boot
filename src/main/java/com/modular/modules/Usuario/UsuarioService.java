package com.modular.modules.Usuario;

import java.util.List;

import org.springframework.stereotype.Service;

import com.modular.modules.Usuario.Entity.UsuarioEntity;
import com.modular.modules.Usuario.Repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioEntity createUsuario(UsuarioEntity usuarioDto) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setNombre(usuarioDto.getNombre());
        usuarioEntity.setUsuario(usuarioDto.getUsuario());
        usuarioEntity.setCorreo(usuarioDto.getCorreo());
        usuarioEntity.setContrasena(usuarioDto.getContrasena());
        UsuarioEntity savedEntity = usuarioRepository.save(usuarioEntity);
        return savedEntity;
    }

    public List<UsuarioEntity> getUsuarios() {
        return usuarioRepository.findAll();
    }

    public UsuarioEntity login(String usuario, String contrasena) {
        UsuarioEntity usuarioEntity = usuarioRepository.findByUsuarioAndContrasena(usuario, contrasena);
        if (usuarioEntity == null) {
            throw new RuntimeException("Usuario o contraseña incorrectos");
        }
        return usuarioEntity;
    }
}
