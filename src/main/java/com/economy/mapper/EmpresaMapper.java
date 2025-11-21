package com.economy.mapper;

import com.economy.domain.model.Empresa;
import com.economy.dto.input.EmpresaInputDto;
import com.economy.dto.output.EmpresaOutputDto;

import java.util.Date;

public class EmpresaMapper {
    public static EmpresaOutputDto toDto(Empresa empresa) {
        return new EmpresaOutputDto(
                empresa.getId(),
                empresa.getNome(),
                empresa.getCnpj(),
                empresa.getSaldo(),
                empresa.getDataCriacao()
        );
    }

    public static Empresa toModel(EmpresaInputDto dto) {
        return new Empresa(
                0,
                dto.getNome(),
                dto.getCnpj(),
                dto.getSaldo(),
                new Date(),
                dto.getSenha()
        );
    }
}
