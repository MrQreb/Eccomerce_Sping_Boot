package com.modular.modules.Producto;

import com.modular.modules.Categoria.Entity.CategoriaEntity;
import com.modular.modules.Categoria.Repository.CategoriaRepository;
import com.modular.modules.Producto.Entity.ProductoEntity;
import com.modular.modules.Producto.Repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductoService {
    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProductoService(
            ProductoRepository productoRepository,
            CategoriaRepository categoriaRepository
    )
    {
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public void createProducto( ProductoEntity producto, long categoriaId){
        ProductoEntity newProducto = new ProductoEntity();
        newProducto.setPrecio( producto.getPrecio() );
        newProducto.setNombre( producto.getNombre() );
        newProducto.setDescripcion( producto.getDescripcion() );
        newProducto.setStock( producto.getStock() );
        CategoriaEntity categoria = categoriaRepository.findById(categoriaId).orElseThrow(() -> new RuntimeException("Categoria no existe"));
        newProducto.setCategoria(categoria);
        productoRepository.save(newProducto);

    }



    public List<ProductoEntity> getProductos(Long categoriaId) {
        if (categoriaId == null || categoriaId == 0) {
            return productoRepository.findByEstaEliminadoFalse();
        }
        return productoRepository.findByCategoriaIdAndEstaEliminadoFalse(categoriaId);
    }

    public Optional<ProductoEntity> getProductoById(long id) {
        return productoRepository.findById(id);
    }

    public void updateProducto(long id, ProductoEntity updatedProducto, long categoriaId) {
        ProductoEntity existingProducto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        existingProducto.setNombre(updatedProducto.getNombre());
        existingProducto.setDescripcion(updatedProducto.getDescripcion());
        existingProducto.setPrecio(updatedProducto.getPrecio());

        CategoriaEntity categoria = categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new RuntimeException("Categoria no existe"));
        existingProducto.setCategoria(categoria);

        productoRepository.save(existingProducto);
    }


    public void deleteProducto(long id) {
        ProductoEntity producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        producto.setEstaEliminado(true);
        productoRepository.save(producto);
    }

}
