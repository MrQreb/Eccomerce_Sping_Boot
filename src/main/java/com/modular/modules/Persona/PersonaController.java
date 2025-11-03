package com.modular.modules.Persona;

import java.util.List;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modular.modules.Persona.Dto.CreatePersonaDto;
import com.modular.modules.Persona.Entity.Persona;
import com.modular.modules.Persona.Service.PersonaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/personas")
@Tag(name = "Personas", description = "API para la gestión de personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    @Operation(summary = "Obtener todas las personas")
    public ResponseEntity<List<Persona>> getAllPersonas() {
        List<Persona> personas = personaService.getAllPersonas();
        return ResponseEntity.ok(personas);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una persona por ID")
    public ResponseEntity<Persona> getPersonaById(@PathVariable Long id) {
        Persona persona = personaService.getPersonaById(id);
        return ResponseEntity.ok(persona);
    }

    @PostMapping
    @Operation(summary = "Crear una nueva persona")
    public ResponseEntity<Persona> createPersona(@Valid @RequestBody CreatePersonaDto dto) {
        Persona persona = personaService.createPersona(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(persona);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una persona existente")
    public ResponseEntity<Persona> updatePersona(@PathVariable Long id, @RequestBody Persona personaDetails) {
        Persona persona = personaService.updatePersona(id, personaDetails);
        return ResponseEntity.ok(persona);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una persona por ID")
    public ResponseEntity<Void> deletePersona(@PathVariable Long id) {
        personaService.deletePersona(id);
        return ResponseEntity.noContent().build();
    }
}