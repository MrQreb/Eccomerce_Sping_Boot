package com.modular.modules.Carrito;

import com.modular.modules.Carrito.Entity.CarritoEntity;
import com.modular.modules.Carrito.Entity.CarritoProductoEntity;
import com.modular.modules.Carrito.Repository.CarritoRepository;
import com.modular.modules.Producto.Entity.ProductoEntity;
import com.modular.modules.Producto.Repository.ProductoRepository;
import com.modular.modules.Usuario.Entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoService {

    private CarritoRepository carritoRepository;

    private ProductoRepository productoRepository;

    public CarritoService(CarritoRepository carritoRepository, ProductoRepository productoRepository) {
        this.carritoRepository = carritoRepository;
        this.productoRepository = productoRepository;
    }

    public void addToCart(Long usuarioId, Long productoId, int cantidad) {

        //Obtener los productos
        ProductoEntity producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        //Crear carrito del usuario
        CarritoEntity carrito = carritoRepository.findByUsuarioId(usuarioId)
                .orElseGet(() -> {
                    CarritoEntity nuevoCarrito = new CarritoEntity();
                    UsuarioEntity usuario = new UsuarioEntity();
                    usuario.setId(usuarioId);
                    nuevoCarrito.setUsuario(usuario);
                    return carritoRepository.save(nuevoCarrito);
                });

        //Agregar producto al carrito
        CarritoProductoEntity carritoProducto = new CarritoProductoEntity();
        carritoProducto.setProducto(producto);
        carritoProducto.setCantidad(cantidad);
        carritoProducto.setCarrito(carrito);

        carrito.getProductos().add(carritoProducto);
        carritoRepository.save(carrito);
    }


    public List<CarritoProductoEntity> getProductosInCarrito(Long usuarioId) {
        return carritoRepository.findByUsuarioId(usuarioId)
                .map(CarritoEntity::getProductos)
                .orElseGet(() -> List.of());
    }


    public void deleteCartByUsuarioId(Long usuarioId) {
        CarritoEntity carrito = carritoRepository.findByUsuarioId(usuarioId)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado para el usuario"));

        carrito.getProductos().clear();
        carritoRepository.delete(carrito);
    }

}
