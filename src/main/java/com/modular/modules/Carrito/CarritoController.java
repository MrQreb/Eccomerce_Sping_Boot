package com.modular.modules.Carrito;

import com.modular.modules.Carrito.Entity.CarritoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carritos")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    @GetMapping
    public List<CarritoEntity> getAllCarritos() {
        return carritoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarritoEntity> getCarritoById(@PathVariable Long id) {
        return carritoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CarritoEntity createCarrito(@RequestBody CarritoEntity carrito) {
        return carritoService.save(carrito);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarritoEntity> updateCarrito(@PathVariable Long id, @RequestBody CarritoEntity carrito) {
        return carritoService.findById(id)
                .map(existingCarrito -> {
                    carrito.setId(existingCarrito.getId());
                    return ResponseEntity.ok(carritoService.save(carrito));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarrito(@PathVariable Long id) {
        if (carritoService.findById(id).isPresent()) {
            carritoService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
