package com.economy.domain.service;

import com.economy.domain.model.Deposito;

import java.util.List;

public interface DepositoService {
    Deposito criarDeposito(Deposito deposito);

    List<Deposito> listarDepositos();

    List<Deposito> listarByEmpresaId(int empresaId);
}
