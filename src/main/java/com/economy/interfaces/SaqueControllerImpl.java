package com.economy.interfaces;

import com.economy.domain.model.Saque;
import com.economy.domain.service.SaqueService;

import java.util.List;

public class SaqueControllerImpl implements SaqueController {
    private final SaqueService saqueService;

    public SaqueControllerImpl(SaqueService saqueService) {
        this.saqueService = saqueService;
    }

    @Override
    public Saque criarSaque(Saque saque) {
        return saqueService.criarSaque(saque);
    }

    @Override
    public List<Saque> listarByEmpregadoId(int empregadoId) {
        return saqueService.listarByEmpregadoId(empregadoId);
    }
}
