package com.modular.modules.TipoPago.Repository;

import com.modular.modules.TipoPago.Entity.TipoPagoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPagoRepository  extends JpaRepository<TipoPagoEntity, Long> {
}

