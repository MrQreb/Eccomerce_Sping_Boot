package com.modular.modules.MovimientoInventario.Entity;

import com.modular.modules.Categoria.Entity.CategoriaEntity;
import com.modular.modules.Producto.Entity.ProductoEntity;
import com.modular.modules.Provedor.Entity.ProvedorEntity;
import jakarta.persistence.*;
@Entity
@Table(name = "MovimientoInventario")
public class MovimientoInventarioEntitiy {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = true)
    private Integer stockAnterior;

    @Column(nullable = true)
    private Integer stockNuevo;

    @Column(nullable = true)
    private Integer cantidadAnadida;

    @Column(nullable = true)
    private Float totalMovimiento;

    @ManyToOne
    @JoinColumn(name = "provedor_id", nullable = false)
    private ProvedorEntity provedor;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private ProductoEntity producto;

    public MovimientoInventarioEntitiy() {
        // optional defaults or leave fields null
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getTotalMovimiento() {
        return totalMovimiento;
    }

    public void setTotalMovimiento(Float totalMovimiento) {
        this.totalMovimiento = totalMovimiento;
    }

    public Integer getStockAnterior() {
        return stockAnterior;
    }

    public void setStockAnterior(Integer stockAnterior) {
        this.stockAnterior = stockAnterior;
    }

    public Integer getStockNuevo() {
        return stockNuevo;
    }

    public void setStockNuevo(Integer stockNuevo) {
        this.stockNuevo = stockNuevo;
    }

    public Integer getCantidadAnadida() {
        return cantidadAnadida;
    }

    public void setCantidadAnadida(Integer cantidadAnadida) {
        this.cantidadAnadida = cantidadAnadida;
    }

    public ProvedorEntity getProvedor() {
        return provedor;
    }

    public void setProvedor(ProvedorEntity provedor) {
        this.provedor = provedor;
    }

    public ProductoEntity getProducto() {
        return producto;
    }

    public void setProducto(ProductoEntity producto) {
        this.producto = producto;
    }
}