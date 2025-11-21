package com.economy.interfaces;

import com.economy.domain.model.Proposta;

import java.util.List;

public interface PropostaController {
    Proposta criarProposta(Proposta proposta);
    Proposta editarProposta(int id, Proposta proposta);
    void deletarProposta(int id);
    Proposta buscarPorId(int id);
    List<Proposta> listarPropostas();
    List<Proposta> listarPropostasPorEmpregado(int empregadoId);
    List<Proposta> listarPropostasPorEmpresa(int empresaId);
}
