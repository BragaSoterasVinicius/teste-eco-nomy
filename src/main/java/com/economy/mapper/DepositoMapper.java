package com.economy.mapper;

import com.economy.domain.model.Deposito;
import com.economy.dto.input.DepositoInputDto;
import com.economy.dto.output.DepositoOutputDto;

import java.util.Date;

public class DepositoMapper {
    public static DepositoOutputDto toDto(Deposito deposito ) {
        return new DepositoOutputDto(
                deposito.getId(),
                deposito.getEmpresaId(),
                deposito.getValor(),
                deposito.getOrigem(),
                deposito.getDateDeposito()
        );
    }

    public static Deposito toModel(DepositoInputDto dto) {
        return new Deposito(
                0,
                dto.getEmpresaId(),
                dto.getValor(),
                dto.getOrigem(),
                new Date()
        );
    }
}

