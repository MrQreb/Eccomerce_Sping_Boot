package com.modular.modules.Pedido.Repository;

import com.modular.modules.Pedido.Entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
    List<PedidoEntity> findByCarritoUsuarioId(Long usuarioId);

}