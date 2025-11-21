package com.economy.interfaces;

import com.economy.domain.model.Proposta;
import com.economy.domain.service.PropostaService;

import java.util.List;
public class PropostaControllerImpl implements PropostaController {
    private final PropostaService propostaService;

    public PropostaControllerImpl(PropostaService propostaService ) {
        this.propostaService = propostaService;
    }

    @Override
    public Proposta criarProposta(Proposta proposta) {
        return propostaService.criarProposta(proposta);
    }

    @Override
    public Proposta editarProposta(int id, Proposta proposta) {
        return propostaService.editarProposta(proposta, id);
    }

    @Override
    public void deletarProposta(int id) {
        propostaService.deletarProposta(id);
    }

    @Override
    public Proposta buscarPorId(int id) {
        return propostaService.getPropostaById(id);
    }

    @Override
    public List<Proposta> listarPropostas() {
        return propostaService.listarPropostas();
    }

    @Override
    public List<Proposta> listarPropostasPorEmpregado(int empregadoId) {
        return propostaService.listarByEmpregadoId(empregadoId);
    }

    @Override
    public List<Proposta> listarPropostasPorEmpresa(int empresaId) {
        return propostaService.listarByEmpresaId(empresaId);
    }
}
