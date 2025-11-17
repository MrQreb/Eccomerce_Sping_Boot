package com.modular.modules.RolUsuario;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.modular.modules.RolUsuario") 
@EnableJpaRepositories(basePackages = "com.modular.modules.RolUsuario.Repository")
@EntityScan(basePackages = "com.modular.modules.RolUsuario.Entity")
public class RolUsuarioModule {
    
}
