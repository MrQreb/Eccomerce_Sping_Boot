package com.modular.modular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.modular.modules.RolUsuario.RolUsuarioModule;
import com.modular.modules.Usuario.UsuarioModule;


@SpringBootApplication()
@Import({ UsuarioModule.class, RolUsuarioModule.class }) 
 
public class ModularApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModularApplication.class, args);
    }
}