package com.economy.application.service;

import com.economy.domain.model.Deposito;
import com.economy.domain.repository.DepositoRepository;
import com.economy.domain.service.DepositoService;

import java.util.List;

public class DepositoServiceImpl implements DepositoService {

    private final DepositoRepository depositoRepository;

    public DepositoServiceImpl(DepositoRepository depositoRepository) {
        this.depositoRepository = depositoRepository;
    }

    @Override
    public Deposito criarDeposito(Deposito deposito) {
        return depositoRepository.criarDeposito(deposito);
    }

    @Override
    public List<Deposito> listarDepositos() {
        return depositoRepository.listarDepositos();
    }

    @Override
    public List<Deposito> listarByEmpresaId(int empresaId) {
        return depositoRepository.listarByEmpresaId(empresaId);
    }
}
