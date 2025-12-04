package com.modular.modules.EstatusCompra;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.modular.modules.TipoPago")
@EnableJpaRepositories(basePackages = "com.modular.modules.TipoPago.Repository")
@EntityScan(basePackages = "com.modular.modules.TipoPago.Entity")
public class TipoPagoModule {
}
