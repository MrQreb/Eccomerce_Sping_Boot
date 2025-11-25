package com.modular.modules.MovimientoInventario;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.modular.modules.MovimientoInventario")
@EnableJpaRepositories(basePackages = "com.modular.modules.MovimientoInventario.Repository")
@EntityScan(basePackages = "com.modular.modules.MovimientoInventario.Entity")
public class MovimientoInventarioModule {
}
