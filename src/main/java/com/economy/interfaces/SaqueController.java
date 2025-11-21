package com.economy.interfaces;

import com.economy.domain.model.Saque;

import java.util.List;

public interface SaqueController {
    Saque criarSaque(Saque saque);
    List<Saque> listarByEmpregadoId(int empregadoId);
}
