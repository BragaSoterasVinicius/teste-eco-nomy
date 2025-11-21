
package com.economy.domain.service;

import com.economy.domain.model.Saque;

import java.util.List;

public interface SaqueService {
    Saque criarSaque(Saque saque);
    List<Saque> listarByEmpregadoId(int empregadoId);
}
