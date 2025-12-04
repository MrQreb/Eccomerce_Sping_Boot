package com.modular.modules.EstatusCompra.Repository;
import com.modular.modules.EstatusCompra.Entity.EstatusCompraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstatusCompraRepository extends JpaRepository<EstatusCompraEntity, Long> {
}

