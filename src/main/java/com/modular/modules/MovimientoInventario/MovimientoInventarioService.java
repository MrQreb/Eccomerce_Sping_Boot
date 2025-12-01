package com.modular.modules.MovimientoInventario;

import com.modular.modules.MovimientoInventario.Entity.MovimientoInventarioEntitiy;
import com.modular.modules.MovimientoInventario.Repository.MovientoInventarioRepository;
import com.modular.modules.Producto.Entity.ProductoEntity;
import com.modular.modules.Producto.MovimientoDto;
import com.modular.modules.Producto.Repository.ProductoRepository;
import com.modular.modules.Provedor.Entity.ProvedorEntity;
import com.modular.modules.Provedor.Repository.ProvedorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MovimientoInventarioService {

    private final MovientoInventarioRepository movimientoInventarioRepository;
    private final ProductoRepository productoRepository;
    private final ProvedorRepository provedorRepository;

    public MovimientoInventarioService(
            MovientoInventarioRepository movimientoInventarioRepository,
            ProductoRepository productoRepository,
            ProvedorRepository provedorRepository
    ) {
        this.movimientoInventarioRepository = movimientoInventarioRepository;
        this.productoRepository = productoRepository;
        this.provedorRepository = provedorRepository;
    }

    public MovimientoInventarioEntitiy guardarMovimiento(MovimientoInventarioEntitiy movimiento) {
        if (movimiento == null || movimiento.getProducto() == null || movimiento.getProvedor() == null) {
            throw new IllegalArgumentException("Movimiento, producto o provedor nulo");
        }

        int cantidadAnadida = movimiento.getCantidadAnadida();
        Long productoId = movimiento.getProducto().getId();
        Long provedorId = movimiento.getProvedor().getId();

        ProductoEntity producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

        ProvedorEntity provedor = provedorRepository.findById(provedorId)
                .orElseThrow(() -> new IllegalArgumentException("Provedor no encontrado"));

        int stockActual = producto.getStock();
        movimiento.setStockAnterior(stockActual);
        int stockNuevo = stockActual + cantidadAnadida;
        movimiento.setStockNuevo(stockNuevo);

        float parsedPrice = (float) producto.getPrecio();
        float totalMovimiento = cantidadAnadida * parsedPrice;

        movimiento.setProducto(producto);
        movimiento.setProvedor(provedor);
        movimiento.setTotalMovimiento(totalMovimiento);
        producto.setStock(stockNuevo);
        producto.getMovimientosInventario().add(movimiento);

        provedor.getMovimientosInventario().add(movimiento);

        MovimientoInventarioEntitiy saved = movimientoInventarioRepository.save(movimiento);
        productoRepository.save(producto);
        provedorRepository.save(provedor);
        return saved;
    }

    public List<MovimientoInventarioEntitiy> findAll(){
        return  movimientoInventarioRepository.findAll();
    }

    public List<MovimientoDto> mapMovimientosToDto(List<MovimientoInventarioEntitiy> movimientos) {
        return movimientos.stream()
                .map(m -> new MovimientoDto(
                        m.getProducto() != null ? m.getProducto().getNombre() : "N/A",
                        m.getProvedor() != null ? m.getProvedor().getNombre() : "N/A",
                        m.getCantidadAnadida(),
                        m.getStockAnterior(),
                        m.getStockNuevo(),
                        m.getTotalMovimiento()
                ))
                .collect(Collectors.toList());
    }

}
