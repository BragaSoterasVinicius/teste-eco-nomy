package com.economy.domain.repository;

import com.economy.domain.model.Empregado;

import java.util.List;

public interface EmpregadoRepository {
    Empregado criarEmpregado(Empregado empregado);

    Empregado editarEmpregado(Empregado empregado, int idEmpregado);

    void deletarEmpregado(int idEmpregado);

    List<Empregado> listarEmpregados();

    List<Empregado> listarByIdUsuario(int idUsuario);

    Empregado loginEmpregado(String email, String senha);
}
