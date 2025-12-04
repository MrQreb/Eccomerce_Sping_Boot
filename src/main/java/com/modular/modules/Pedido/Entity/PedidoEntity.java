package com.modular.modules.Pedido.Entity;

import com.modular.modules.Carrito.Entity.CarritoEntity;
import com.modular.modules.EstatusCompra.Entity.EstatusCompraEntity;
import com.modular.modules.TipoPago.Entity.TipoPagoEntity;
import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "pedido")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "carrito_id", nullable = false)
    private CarritoEntity carrito;

    @ManyToOne
    @JoinColumn(name = "estatus_compra_id", nullable = false)
    private EstatusCompraEntity estatusCompra;

    @ManyToOne
    @JoinColumn(name = "tipo_pago_id", nullable = false)
    private TipoPagoEntity tipoPago;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarritoEntity getCarrito() {
        return carrito;
    }

    public void setCarrito(CarritoEntity carrito) {
        this.carrito = carrito;
    }

    public EstatusCompraEntity getEstatusCompra() {
        return estatusCompra;
    }

    public void setEstatusCompra(EstatusCompraEntity estatusCompra) {
        this.estatusCompra = estatusCompra;
    }

    public TipoPagoEntity getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPagoEntity tipoPago) {
        this.tipoPago = tipoPago;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}