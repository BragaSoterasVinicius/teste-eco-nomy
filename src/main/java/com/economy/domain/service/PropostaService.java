
package com.economy.domain.service;

import com.economy.domain.model.Proposta;

import java.util.List;

public interface PropostaService {
    Proposta criarProposta(Proposta proposta);

    Proposta editarProposta(Proposta proposta, int idProposta);

    void deletarProposta(int idProposta);

    List<Proposta> listarPropostas();

    List<Proposta> listarByEmpresaId(int empresaId);

    List<Proposta> listarByEmpregadoId(int empregadoId);

    Proposta getPropostaById(int id);
}
