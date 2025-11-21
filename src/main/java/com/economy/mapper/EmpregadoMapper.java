package com.economy.mapper;

import com.economy.domain.model.Empregado;
import com.economy.dto.input.EmpregadoInputDto;
import com.economy.dto.output.EmpregadoOutputDto;

public class EmpregadoMapper {

    public static EmpregadoOutputDto toDto(Empregado empregado) {
        return new EmpregadoOutputDto(
                empregado.getEmpregadoId(),
                empregado.getCpf(),
                empregado.getNome(),
                empregado.getEmail(),
                empregado.getSaldo(),
                empregado.getDataCriacao()
        );
    }

    public static Empregado toModel(EmpregadoInputDto dto) {
        return new Empregado(
                dto.getEmpregadoId(),
                dto.getCpf(),
                dto.getNome(),
                dto.getEmail(),
                dto.getSaldo(),
                dto.getDataCriacao(),
                dto.getSenha()
        );
    }
}
