package com.modular.modules.Persona.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modular.modules.Persona.Entity.Persona;
import com.modular.modules.Persona.PersonaRepository;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }

    public Optional<Persona> getPersonaById(Long id) {
        return personaRepository.findById(id);
    }

    public Persona createPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    public Persona updatePersona(Long id, Persona personaDetails) {
        Persona persona = personaRepository.findById(id).orElseThrow();
        persona.setNombre(personaDetails.getNombre());
        persona.setApellido(personaDetails.getApellido());
        return personaRepository.save(persona);
    }

    public void deletePersona(Long id) {
        personaRepository.deleteById(id);
    }
}
