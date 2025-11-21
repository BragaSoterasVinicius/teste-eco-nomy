package com.economy.domain.service;

import com.economy.domain.model.Empresa;

import java.util.List;

public interface EmpresaService {
    Empresa criarEmpresa(Empresa empresa);

    Empresa editarEmpresa(Empresa empresa, int idEmpresa);

    void deletarEmpresa(int idEmpresa);

    List<Empresa> listarEmpresas();

    List<Empresa> listarById(int id);

    Empresa login(String email, String senha);
}
