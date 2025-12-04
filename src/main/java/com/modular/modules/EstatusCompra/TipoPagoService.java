package com.modular.modules.EstatusCompra;

import com.modular.modules.TipoPago.Entity.TipoPagoEntity;
import com.modular.modules.TipoPago.Repository.TipoPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoPagoService {


    private TipoPagoRepository tipoPagoRepository;

    public TipoPagoService(TipoPagoRepository tipoPagoRepository) {
        this.tipoPagoRepository = tipoPagoRepository;
    }

    public TipoPagoEntity createTipoPago(TipoPagoEntity tipoPago) {
        return tipoPagoRepository.save(tipoPago);
    }

    public List<TipoPagoEntity> findAllTipoPago() {
        return tipoPagoRepository.findAll();
    }
}
