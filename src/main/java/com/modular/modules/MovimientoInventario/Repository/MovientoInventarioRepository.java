package com.modular.modules.MovimientoInventario.Repository;

import com.modular.modules.MovimientoInventario.Entity.MovimientoInventarioEntitiy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovientoInventarioRepository extends JpaRepository<MovimientoInventarioEntitiy, Long> {
}
