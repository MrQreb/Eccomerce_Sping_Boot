package com.modular.modular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.modular.modules.Persona.Entity")
@EnableJpaRepositories(basePackages = "com.modular.modules.Persona")
@ComponentScan(basePackages = "com.modular.modules.Persona")
public class ModularApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModularApplication.class, args);
	}

}
