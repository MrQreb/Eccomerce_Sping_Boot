package com.modular.modules.Pedido;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.modular.modules.Pedido")
@EnableJpaRepositories(basePackages = "com.modular.modules.Pedido.Repository")
@EntityScan(basePackages = "com.modular.modules.Pedido.Entity")
public class PedidoModule {
}
