package com.modular.modular;

import com.modular.modules.Producto.ProductoModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.modular.modules.Categoria.CategoriaModule;
import com.modular.modules.RolUsuario.RolUsuarioModule;
import com.modular.modules.Usuario.UsuarioModule;


@SpringBootApplication()
@Import({ UsuarioModule.class, RolUsuarioModule.class, CategoriaModule.class, ProductoModule.class})

public class ModularApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModularApplication.class, args);
    }
}