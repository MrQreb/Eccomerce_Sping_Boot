package com.modular.modules.Direccion.Repository;

import com.modular.modules.Direccion.Entity.DireccionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DireccionRepository extends JpaRepository<DireccionEntity, Long > {
    List<DireccionEntity> findByUsuarioId(Long usuarioId);

}
