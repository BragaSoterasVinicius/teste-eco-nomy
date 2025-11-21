package com.economy.interfaces;

import com.economy.domain.model.Empregado;

import java.util.List;

public interface EmpregadoController {

    Empregado criarEmpregado(Empregado empregado);

    Empregado editarEmpregado(int id, Empregado empregado);

    void deletarEmpregado(int id);

    Empregado buscarPorId(int id);

    List<Empregado> listarEmpregados();

    Empregado loginEmpregado(String email, String senha);
}
