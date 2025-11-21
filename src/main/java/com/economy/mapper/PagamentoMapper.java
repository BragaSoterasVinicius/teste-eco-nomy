package com.economy.mapper;

import com.economy.domain.model.Pagamento;
import com.economy.dto.input.PagamentoInputDto;
import com.economy.dto.output.PagamentoOutputDto;

// TODO 18112025
// TODO vale a pena dar uma olhada nessas classes Dtos e deletar tudo que nao eh usado em operacoes....

public class PagamentoMapper {
    public static PagamentoOutputDto toDto(Pagamento pagamento ) {
        return new PagamentoOutputDto(
                pagamento.getId(),
                pagamento.getPropostaId(),
                pagamento.getEmpresaId(),
                pagamento.getEmpregadoId(),
                pagamento.getValor(),
                pagamento.getDataPagamento()
        );
    }

    public static Pagamento toModel(PagamentoInputDto dto) {
        return new Pagamento(
                dto.getEmpregadoId(),
                dto.getPropostaId(),
                dto.getEmpresaId(),
                dto.getEmpregadoId(),
                dto.getValor(),
                dto.getDataPagamento()
        );
    }
}

