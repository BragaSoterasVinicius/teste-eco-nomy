
package com.economy.application.service;

import com.economy.domain.model.Saque;
import com.economy.domain.repository.SaqueRepository;
import com.economy.domain.service.SaqueService;

import java.util.List;

public class SaqueServiceImpl implements SaqueService {

    private final SaqueRepository saqueRepository;

    public SaqueServiceImpl(SaqueRepository saqueRepository) {
        this.saqueRepository = saqueRepository;
    }

    @Override
    public Saque criarSaque(Saque saque) {
        return saqueRepository.criarSaque(saque);
    }

    @Override
    public List<Saque> listarByEmpregadoId(int empregadoId) {
        return saqueRepository.listarByEmpregadoId(empregadoId);
    }
}
