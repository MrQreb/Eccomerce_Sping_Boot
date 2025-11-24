package com.modular.modules.Provedor;

import com.modular.modules.Provedor.Entity.ProvedorEntity;
import com.modular.modules.Provedor.Repository.ProvedorRepository;
import org.springframework.stereotype.Service;

@Service
public class ProvedorService {
    private final ProvedorRepository provedorRepository;

    public ProvedorService(ProvedorRepository provedorRepository) {
        this.provedorRepository = provedorRepository;
    }

    public void createProvedor(String nombre){
        ProvedorEntity newProvedor = new ProvedorEntity();
        newProvedor.setNombre(nombre);
        provedorRepository.save(newProvedor);
    }
}
