package com.economy.domain.repository;

import com.economy.domain.model.Deposito;
import java.util.List;

public interface DepositoRepository {
     Deposito criarDeposito(Deposito deposito);

    Deposito editarDeposito(Deposito deposito, int idDeposito);

    void deletarDeposito(int idDeposito);

    List<Deposito> listarDepositos();

    List<Deposito> listarByEmpresaId(int empresaId);
}
