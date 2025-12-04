package com.modular.modules.Pedido;

import com.modular.modules.Carrito.Entity.CarritoEntity;
import com.modular.modules.Carrito.Repository.CarritoRepository;
import com.modular.modules.EstatusCompra.Entity.EstatusCompraEntity;
import com.modular.modules.EstatusCompra.Repository.EstatusCompraRepository;
import com.modular.modules.Pedido.Entity.PedidoEntity;
import com.modular.modules.Pedido.Repository.PedidoRepository;
import com.modular.modules.TipoPago.Entity.TipoPagoEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class PedidoService {


    private PedidoRepository pedidoRepository;


    private EstatusCompraRepository estatusCompraRepository;
    private CarritoRepository carritoRepository;

    public PedidoService(PedidoRepository pedidoRepository, EstatusCompraRepository estatusCompraRepository, CarritoRepository carritoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.estatusCompraRepository = estatusCompraRepository;
        this.carritoRepository = carritoRepository;
    }

    public PedidoEntity crearPedido(CarritoEntity carrito, TipoPagoEntity tipoPago) {

        List<EstatusCompraEntity> estatusList = estatusCompraRepository.findAll();
        if (estatusList.isEmpty()) {
            throw new IllegalStateException("No hay estatus de compra disponibles");
        }


        Random random = new Random();
        EstatusCompraEntity estatusAleatorio = estatusList.get(random.nextInt(estatusList.size()));

        PedidoEntity pedido = new PedidoEntity();
        pedido.setCarrito(carrito);
        pedido.setTipoPago(tipoPago);
        pedido.setEstatusCompra(estatusAleatorio);
        pedido.setFechaCreacion(LocalDateTime.now());

        return pedidoRepository.save(pedido);
    }

    public List<PedidoEntity> findByUsuarioId(Long usuarioId) {
        return pedidoRepository.findByCarritoUsuarioId(usuarioId);
    }

    public List<PedidoEntity> findAll() {
        return pedidoRepository.findAll();
    }

    public List<PedidoEntity> buscarPedidosPorUsuarioId(Long usuarioId) {
        return pedidoRepository.findByCarritoUsuarioId(usuarioId);
    }


    public void crearPedidoPorUsuarioId(Long usuarioId, TipoPagoEntity tipoPago) {
        CarritoEntity carrito = carritoRepository.findByUsuarioId(usuarioId)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró un carrito para el usuario con ID: " + usuarioId));

        if (carrito.getProductos() == null || carrito.getProductos().isEmpty()) {
            throw new IllegalStateException("El carrito está vacío. No se puede crear un pedido.");
        }

        List<EstatusCompraEntity> estatusList = estatusCompraRepository.findAll();
        if (estatusList.isEmpty()) {
            throw new IllegalStateException("No hay estatus de compra disponibles");
        }

        Random random = new Random();
        EstatusCompraEntity estatusAleatorio = estatusList.get(random.nextInt(estatusList.size()));

        PedidoEntity pedido = new PedidoEntity();
        pedido.setCarrito(carrito);
        pedido.setTipoPago(tipoPago);
        pedido.setEstatusCompra(estatusAleatorio);
        pedido.setFechaCreacion(LocalDateTime.now());

        pedidoRepository.save(pedido);

        carrito.getProductos().clear();
    }
}
