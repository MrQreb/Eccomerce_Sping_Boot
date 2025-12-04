package com.modular.modules.EstatusCompra;

import com.modular.modules.EstatusCompra.Entity.EstatusCompraEntity;
import com.modular.modules.EstatusCompra.Repository.EstatusCompraRepository;
import com.modular.modules.TipoPago.Entity.TipoPagoEntity;
import com.modular.modules.TipoPago.Repository.TipoPagoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstatusCompraService {


    private final EstatusCompraRepository estatusCompraRepository;

    public EstatusCompraService(EstatusCompraRepository estatusCompraRepository) {
        this.estatusCompraRepository = estatusCompraRepository;
    }

    public EstatusCompraEntity createEstatusCompra(EstatusCompraEntity estatusCompra) {
        return estatusCompraRepository.save(estatusCompra);
    }

    public List<EstatusCompraEntity> findAllEstatusCompra() {
        return estatusCompraRepository.findAll();
    }
}
