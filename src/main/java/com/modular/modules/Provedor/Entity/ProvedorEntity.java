package com.modular.modules.Provedor.Entity;

import jakarta.persistence.*;

@Table(name = "Provedor")
@Entity
public class ProvedorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
