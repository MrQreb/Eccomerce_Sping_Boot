package com.modular.modules.Persona.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class CreatePersonaDto {
    private String nombre;
    private String apellido;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
}
