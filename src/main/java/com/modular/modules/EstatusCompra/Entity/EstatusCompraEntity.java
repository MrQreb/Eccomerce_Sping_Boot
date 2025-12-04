package com.modular.modules.EstatusCompra.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "estatus_compra")
public class EstatusCompraEntity {
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
