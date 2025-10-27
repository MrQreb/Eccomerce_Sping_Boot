package com.modular.modules.Persona;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modular.modules.Persona.Entity.Persona;
import com.modular.modules.Persona.Service.PersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public List<Persona> getAllPersonas() {
        return personaService.getAllPersonas();
    }

    @GetMapping("/{id}")
    public Optional<Persona> getPersonaById(@PathVariable Long id) {
        return personaService.getPersonaById(id);
    }

    @PostMapping
    public Persona createPersona(@RequestBody Persona persona) {
        return personaService.createPersona(persona);
    }

    @PutMapping("/{id}")
    public Persona updatePersona(@PathVariable Long id, @RequestBody Persona personaDetails) {
        return personaService.updatePersona(id, personaDetails);
    }

    @DeleteMapping("/{id}")
    public void deletePersona(@PathVariable Long id) {
        personaService.deletePersona(id);
    }
}