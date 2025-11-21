
package com.economy.domain.service;

import com.economy.domain.model.Pagamento;

import java.util.List;

public interface PagamentoService {
    Pagamento criarPagamento(Pagamento pagamento);

    Pagamento editarTransacao(int id, Pagamento pagamento);

    Pagamento buscarPorId(int id);

    List<Pagamento> listarPagamentosPorEmpresaId(int empresaId);

    List<Pagamento> listarPagamentosPorEmpregadoId(int id);
}
