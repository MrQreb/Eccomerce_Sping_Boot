package com.modular.modules.Persona.Service;

import com.modular.modules.Persona.Entity.Persona;

public class PersonaCreateResponseDTO {
    private String mensaje;
    private Persona persona;

    public PersonaCreateResponseDTO(String mensaje, Persona persona) {
        this.mensaje = mensaje;
        this.persona = persona;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
