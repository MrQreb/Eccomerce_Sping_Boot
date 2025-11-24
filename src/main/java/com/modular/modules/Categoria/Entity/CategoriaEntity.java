package com.modular.modules.Categoria.Entity;


import com.modular.modules.Producto.Entity.ProductoEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Categoria")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String nombre;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductoEntity> productoEntityList = new ArrayList<ProductoEntity>();


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


    public List<ProductoEntity> getProductoEntityList() {
        return productoEntityList;
    }

    public void setProductoEntityList(List<ProductoEntity> productoEntityList) {
        this.productoEntityList = productoEntityList;
    }
}

