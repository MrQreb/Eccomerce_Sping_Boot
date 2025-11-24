package com.modular.modules.Producto.Repository;

import com.modular.modules.Producto.Entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {
    List<ProductoEntity> findByCategoriaId(Long categoriaId);
    List<ProductoEntity> findByCategoriaNombre(String nombre);

}
