package com.modular.modules.Carrito.Entity;

import com.modular.modules.Usuario.Entity.UsuarioEntity;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Carrito")
public class CarritoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario;

    @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CarritoProductoEntity> productos = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public List<CarritoProductoEntity> getProductos() {
        return productos;
    }

    public void setProductos(List<CarritoProductoEntity> productos) {
        this.productos = productos;
    }

    public void addProducto(CarritoProductoEntity producto) {
        productos.add(producto);
        producto.setCarrito(this);
    }

    public void removeProducto(CarritoProductoEntity producto) {
        productos.remove(producto);
        producto.setCarrito(null);
    }


}
