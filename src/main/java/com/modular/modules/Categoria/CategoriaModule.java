package com.modular.modules.Categoria;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.modular.modules.Categoria")
@EnableJpaRepositories(basePackages = "com.modular.modules.Categoria.Repository")
@EntityScan(basePackages = "com.modular.modules.Categoria.Entity")
public class CategoriaModule {
    
}
