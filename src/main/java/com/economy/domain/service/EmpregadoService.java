package com.economy.domain.service;

import com.economy.domain.model.Empregado;

import java.util.List;

public interface EmpregadoService {
    Empregado criarEmpregado(Empregado empregado);

    Empregado editarEmpregado(int id, Empregado empregado);

    void deletarEmpregado(int id);

    Empregado buscarPorId(int id);

    List<Empregado> listarEmpregados();

    Empregado loginEmpregado(String email, String senha);
}
