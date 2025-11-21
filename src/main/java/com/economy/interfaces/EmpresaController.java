package com.economy.interfaces;

import com.economy.domain.model.Empresa;

import java.util.List;

public interface EmpresaController {
    Empresa criarEmpresa(Empresa empresa);

    Empresa editarEmpresa(int id, Empresa empresa);

    void deletarEmpresa(int id);

    Empresa buscarPorId(int id);

    List<Empresa> listarEmpresas();

    Empresa login(String cnpj, String senha);
}
