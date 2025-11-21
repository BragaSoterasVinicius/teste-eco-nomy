
package com.economy.domain.repository;

import com.economy.domain.model.Pagamento;

import java.util.List;

public interface PagamentoRepository {
    Pagamento criarPagamento(Pagamento pagamento);

    Pagamento editarPagamento(Pagamento pagamento, int idPagamento);

    Pagamento getById(int pagamentoId);

    List<Pagamento> listarPagamentosPorEmpregadoId(int id);

    List<Pagamento> listarPagamentosPorEmpresaId(int empresaId);
}
