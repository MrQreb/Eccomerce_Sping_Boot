package com.modular.modules.Carrito;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.modular.modules.Carrito")
@EnableJpaRepositories(basePackages = "com.modular.modules.Carrito.Repository")
@EntityScan(basePackages = "com.modular.modules.Carrito.Entity")
public class CarritoModule {
}
