package com.modular.modules.Persona;

import com.modular.modules.Persona.Entity.Persona;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}