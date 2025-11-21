
package com.economy.application.service;

import com.economy.domain.model.Proposta;
import com.economy.domain.repository.PropostaRepository;
import com.economy.domain.service.PropostaService;

import java.util.List;

public class PropostaServiceImpl implements PropostaService {

    private final PropostaRepository propostaRepository;
    public PropostaServiceImpl(PropostaRepository propostaRepository) {
        this.propostaRepository = propostaRepository;
    }

    @Override
    public Proposta criarProposta(Proposta proposta) {
        return propostaRepository.criarProposta(proposta);
    }

    @Override
    public Proposta editarProposta(Proposta proposta, int idProposta) {
        return propostaRepository.editarProposta(proposta, idProposta);
    }

    @Override
    public void deletarProposta(int idProposta) {
        propostaRepository.deletarProposta(idProposta);
    }

    @Override
    public List<Proposta> listarPropostas() {
        return propostaRepository.listarPropostas();
    }

    @Override
    public List<Proposta> listarByEmpresaId(int empresaId) {
        return propostaRepository.listarByEmpresaId(empresaId);
    }

    @Override
    public List<Proposta> listarByEmpregadoId(int empregadoId) {
        return propostaRepository.listarByEmpregadoId(empregadoId);
    }

    @Override
    public Proposta getPropostaById(int id) {
        return propostaRepository.getProposta(id);
    }
}
