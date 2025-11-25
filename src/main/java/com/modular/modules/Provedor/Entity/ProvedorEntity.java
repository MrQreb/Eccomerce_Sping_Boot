package com.modular.modules.Provedor.Entity;

import com.modular.modules.MovimientoInventario.Entity.MovimientoInventarioEntitiy;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "Provedor")
@Entity
public class ProvedorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @OneToMany(mappedBy = "provedor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MovimientoInventarioEntitiy> movimientosInventario = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<MovimientoInventarioEntitiy> getMovimientosInventario() {
        return movimientosInventario;
    }

    public void setMovimientosInventario(List<MovimientoInventarioEntitiy> movimientosInventario) {
        this.movimientosInventario = movimientosInventario;
    }
}
