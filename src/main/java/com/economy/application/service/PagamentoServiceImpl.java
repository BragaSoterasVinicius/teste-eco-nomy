
package com.economy.application.service;

import com.economy.domain.model.Pagamento;
import com.economy.domain.repository.PagamentoRepository;
import com.economy.domain.service.PagamentoService;

import java.util.List;

public class PagamentoServiceImpl implements PagamentoService {

    private final PagamentoRepository pagamentoRepository;

    public PagamentoServiceImpl(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    @Override
    public Pagamento criarPagamento(Pagamento pagamento) {
        return pagamentoRepository.criarPagamento(pagamento);
    }

    @Override
    public Pagamento editarTransacao(int id, Pagamento pagamento) {
        return pagamentoRepository.editarPagamento(pagamento, id);
    }

    @Override
    public Pagamento buscarPorId(int id) {
        return pagamentoRepository.getById(id);
    }

    @Override
    public List<Pagamento> listarPagamentosPorEmpresaId(int empresaId) {
        return pagamentoRepository.listarPagamentosPorEmpresaId(empresaId);
    }

    @Override
    public List<Pagamento> listarPagamentosPorEmpregadoId(int id) {
        return pagamentoRepository.listarPagamentosPorEmpregadoId(id);
    }
}
