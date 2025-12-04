package com.modular.modules.TipoPago.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_pago")
public class TipoPagoEntity {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
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
