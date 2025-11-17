package com.modular.modules.Usuario;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.modular.modules.Usuario") 
@EnableJpaRepositories(basePackages = "com.modular.modules.Usuario.Repository")
@EntityScan(basePackages = "com.modular.modules.Usuario.Entity")
public class UsuarioModule {
}