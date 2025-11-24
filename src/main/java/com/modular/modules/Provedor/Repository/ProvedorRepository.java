package com.modular.modules.Provedor.Repository;

import com.modular.modules.Provedor.Entity.ProvedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvedorRepository extends JpaRepository<ProvedorEntity, Long> {
}
