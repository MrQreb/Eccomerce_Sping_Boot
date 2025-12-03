package com.modular.modules.Carrito;

import com.modular.modules.Carrito.Entity.CarritoEntity;
import com.modular.modules.Carrito.Repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoService {


    private CarritoRepository carritoRepository;

    public CarritoService(CarritoRepository carritoRepository) {
        this.carritoRepository = carritoRepository;
    }

    public List<CarritoEntity> findAll() {
        return carritoRepository.findAll();
    }

    public Optional<CarritoEntity> findById(Long id) {
        return carritoRepository.findById(id);
    }

    public CarritoEntity save(CarritoEntity carrito) {
        return carritoRepository.save(carrito);
    }

    public void deleteById(Long id) {
        carritoRepository.deleteById(id);
    }
}
