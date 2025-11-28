package com.modular.modules.Usuario;

import java.util.List;

import org.springframework.stereotype.Service;

import com.modular.modules.RolUsuario.RolUsuarioService;
import com.modular.modules.Usuario.Entity.UsuarioEntity;
import com.modular.modules.Usuario.Repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolUsuarioService rolService;

    public UsuarioService(
            UsuarioRepository usuarioRepository,
            RolUsuarioService rolService
    ) {
        this.usuarioRepository = usuarioRepository;
        this.rolService = rolService;
    }

    public boolean countExist(String correo) {
        return usuarioRepository.findByCorreo(correo).isPresent();
    }

    public UsuarioEntity createUsuarioNormal(UsuarioEntity usuario) {
        if (countExist(usuario.getCorreo())) {
            throw new RuntimeException("El correo ya está registrado: " + usuario.getCorreo());
        }

        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setNombre(usuario.getNombre());
        usuarioEntity.setUsuario(usuario.getUsuario());
        usuarioEntity.setCorreo(usuario.getCorreo());
        usuarioEntity.setContrasena(usuario.getContrasena());
        usuarioEntity.setRol(rolService.getUsuarioRol());
        UsuarioEntity savedEntity = usuarioRepository.save(usuarioEntity);
        return savedEntity;
    }


    public UsuarioEntity createUsuarioAdmin(UsuarioEntity usuario) {
        if (countExist(usuario.getCorreo())) {
            throw new RuntimeException("El correo ya está registrado: " + usuario.getCorreo());
        }

        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setNombre(usuario.getNombre());
        usuarioEntity.setUsuario(usuario.getUsuario());
        usuarioEntity.setCorreo(usuario.getCorreo());
        usuarioEntity.setContrasena(usuario.getContrasena());
        usuarioEntity.setRol(rolService.getAdminRol());
        UsuarioEntity savedEntity = usuarioRepository.save(usuarioEntity);
        return savedEntity;
    }

    public UsuarioEntity createUsuario(UsuarioEntity usuario) {

        if (countExist(usuario.getCorreo())) {
            throw new RuntimeException("El correo ya está registrado: " + usuario.getCorreo());
        }

        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setNombre(usuario.getNombre());
        usuarioEntity.setUsuario(usuario.getUsuario());
        usuarioEntity.setCorreo(usuario.getCorreo());
        usuarioEntity.setContrasena(usuario.getContrasena());
        usuario.setRol(rolService.getUsuarioRol());

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
