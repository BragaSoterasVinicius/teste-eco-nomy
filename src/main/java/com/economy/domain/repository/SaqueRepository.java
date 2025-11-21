
package com.economy.domain.repository;

import com.economy.domain.model.Saque;

import java.util.List;

public interface SaqueRepository {
    Saque criarSaque(Saque saque);

    List<Saque> listarByEmpregadoId(int empregadoId);
}
