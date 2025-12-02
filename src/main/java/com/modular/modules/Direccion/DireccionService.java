package com.modular.modules.Direccion;

import com.modular.modules.Direccion.Entity.DireccionEntity;
import com.modular.modules.Direccion.Repository.DireccionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DireccionService {

    private final DireccionRepository direccionRepository;

    public DireccionService(DireccionRepository direccionRepository) {
        this.direccionRepository = direccionRepository;
    }

    public DireccionEntity createDireccion(DireccionEntity direccion) {
        return direccionRepository.save(direccion);
    }

    public DireccionEntity updateDireccion(Long id, DireccionEntity updatedDireccion) {
        DireccionEntity existing = direccionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Direccion not found: " + id));
        BeanUtils.copyProperties(updatedDireccion, existing, "id");
        return direccionRepository.save(existing);
    }

    public void deleteDireccion(Long id) {
        if (!direccionRepository.existsById(id)) {
            throw new IllegalArgumentException("No existe la direccion con id: " + id);
        }
        direccionRepository.deleteById(id);
    }

    public List<DireccionEntity> findByUsuarioId(Long usuarioId) {
        return direccionRepository.findByUsuarioId(usuarioId);
    }
}
