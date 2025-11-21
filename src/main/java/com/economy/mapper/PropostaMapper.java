package com.economy.mapper;

import com.economy.domain.model.Proposta;
import com.economy.dto.input.PropostaInputDto;
import com.economy.dto.output.PropostaOutputDto;

public class PropostaMapper {
    public static PropostaOutputDto toDto(Proposta proposta) {
        return new PropostaOutputDto(
                proposta.getId(),
                proposta.getEmpresaId(),
                proposta.getDescricao(),
                proposta.getValor(),
                proposta.getDataCriacao(),
                proposta.getEmpregadoId(),
                proposta.isLongoPrazo(),
                proposta.getStatus()
        );
    }

    public static Proposta toModel(PropostaInputDto dto) {
        return new Proposta(
                0,
                dto.getEmpresaId(),
                dto.getDescricao(),
                dto.getValor(),
                dto.getDataCriacao(),
                0,
                dto.isLongoPrazo(),
                dto.getStatus()
        );
        //A proposta sempre é criada sem empregado associado
    }
}
