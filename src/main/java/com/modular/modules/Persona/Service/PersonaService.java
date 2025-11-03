package com.modular.modules.Persona.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.modular.modules.Persona.Dto.CreatePersonaDto;
import com.modular.modules.Persona.Entity.Persona;
import com.modular.modules.Persona.PersonaRepository;
import org.springframework.http.HttpStatus;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaService(final PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }

    public Persona getPersonaById(Long id) {
        return personaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Persona no encontrada"));
    }

    public Persona createPersona(CreatePersonaDto dto) {
        Persona persona = new Persona();
        persona.setNombre(dto.getNombre());
        persona.setApellido(dto.getApellido());
        return personaRepository.save(persona);
    }

    public Persona updatePersona(Long id, Persona personaDetails) {
        Persona persona = this.getPersonaById(id);
        persona.setNombre(personaDetails.getNombre());
        persona.setApellido(personaDetails.getApellido());
        return personaRepository.save(persona);
    }

    public void deletePersona(Long id) {
        if (!personaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Persona no encontrada");
        }
        personaRepository.deleteById(id);
    }
}