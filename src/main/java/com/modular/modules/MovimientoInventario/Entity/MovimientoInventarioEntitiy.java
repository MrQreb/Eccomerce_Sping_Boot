package com.modular.modules.MovimientoInventario.Entity;

import com.modular.modules.Producto.Entity.ProductoEntity;
import com.modular.modules.Provedor.Entity.ProvedorEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "MovimientoInventario")
public class MovimientoInventarioEntitiy {

    @Id
    @GeneratedValue()
    Long id;

    @Column
    int stockAnterior;

    @Column
    int stockNuevo;

    @Column
    int cantidadAnadida;

    @Column
    float totalMovimiento;

    @ManyToOne
    @JoinColumn(name = "provedor_id", nullable = false)
    private ProvedorEntity provedor;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private ProductoEntity producto;

    public float getTotalMovimiento() {
        return totalMovimiento;
    }

    public void setTotalMovimiento(float totalMovimiento) {
        this.totalMovimiento = totalMovimiento;
    }

    public int getStockAnterior() {
        return stockAnterior;
    }

    public void setStockAnterior(int stockAnterior) {
        this.stockAnterior = stockAnterior;
    }

    public int getStockNuevo() {
        return stockNuevo;
    }

    public void setStockNuevo(int stockNuevo) {
        this.stockNuevo = stockNuevo;
    }

    public int getCantidadAnadida() {
        return cantidadAnadida;
    }

    public void setCantidadAnadida(int cantidadAnadida) {
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
