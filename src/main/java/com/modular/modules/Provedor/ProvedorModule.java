package com.modular.modules.Provedor;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.modular.modules.Provedor")
@EnableJpaRepositories(basePackages = "com.modular.modules.Provedor.Repository")
@EntityScan(basePackages = "com.modular.modules.Provedor.Entity")
public class ProvedorModule {
}
