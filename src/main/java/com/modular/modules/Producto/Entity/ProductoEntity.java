package com.modular.modules.Producto.Entity;

import com.modular.modules.Categoria.Entity.CategoriaEntity;
import jakarta.persistence.*;

@Entity
@Table( name = "Producto")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String descripcion;

    @Column
    private float precio;

    @Column
    private float stock;

    @Column
    private boolean estaEliminado = false;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = true)
    private CategoriaEntity categoria;

    @Column
    private float minimoStock = 5;

    public void setCategoria(CategoriaEntity categoria) {
        this.categoria = categoria;
    }

    public float getMinimoStock() {
        return minimoStock;
    }

    public void setMinimoStock(float minimoStock) {
        this.minimoStock = minimoStock;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getStock() {
        return stock;
    }

    public void setStock(float stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isEstaEliminado() {
        return estaEliminado;
    }

    public void setEstaEliminado(boolean estaEliminado) {
        this.estaEliminado = estaEliminado;
    }
}
