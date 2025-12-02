package com.modular.modules.Direccion;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.modular.modules.Direccion")
@EnableJpaRepositories(basePackages = "com.modular.modules.Direccion.Repository")
@EntityScan(basePackages = "com.modular.modules.Direccion.Entity")
public class DireccionModule {
}
