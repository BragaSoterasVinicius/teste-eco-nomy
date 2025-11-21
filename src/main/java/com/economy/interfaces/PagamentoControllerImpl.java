package com.economy.interfaces;

import com.economy.domain.model.Pagamento;
import com.economy.domain.service.PagamentoService;

import java.util.List;

public class PagamentoControllerImpl implements PagamentoController {
    private final PagamentoService pagamentoService;
    public PagamentoControllerImpl(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @Override
    public Pagamento criarTransacao(Pagamento pagamento) {
        return pagamentoService.criarPagamento(pagamento);
    }

    @Override
    public Pagamento editarTransacao(int id, Pagamento pagamento) {
        return pagamentoService.editarTransacao(id, pagamento);
    }

    @Override
    public Pagamento buscarPorId(int id) {
        return pagamentoService.buscarPorId(id);
    }

    @Override
    public List<Pagamento> listarPorEmpresa(int empresaId) {
        return pagamentoService.listarPagamentosPorEmpresaId(empresaId);
    }

    @Override
    public List<Pagamento> listarPorEmpregado(int empregadoId) {
        return pagamentoService.listarPagamentosPorEmpregadoId(empregadoId);
    }
}
