package com.modular.modules.Producto;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.modular.modules.Producto")
@EnableJpaRepositories(basePackages = "com.modular.modules.Producto.Repository")
@EntityScan(basePackages = "com.modular.modules.Producto.Entity")
public class ProductoModule {
}
