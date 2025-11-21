package com.economy.interfaces;

import com.economy.domain.model.Pagamento;

import java.util.List;

public interface PagamentoController {
    Pagamento criarTransacao(Pagamento pagamento);

    Pagamento editarTransacao(int id, Pagamento pagamento);

    Pagamento buscarPorId(int id);

    List<Pagamento> listarPorEmpresa(int empresaId);

    List<Pagamento> listarPorEmpregado(int empregadoId);
}
