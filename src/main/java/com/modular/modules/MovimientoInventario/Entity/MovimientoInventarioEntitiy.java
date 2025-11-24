package com.modular.modules.MovimientoInventario.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MovimientoInventario")
public class MovimientoInventarioEntitiy {

    @Id
    @GeneratedValue()
    Long id;


}
