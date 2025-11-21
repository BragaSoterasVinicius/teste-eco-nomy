package com.economy.interfaces;

import com.economy.domain.model.Empresa;
import com.economy.domain.service.EmpresaService;

import java.util.List;

public class EmpresaControllerImpl implements EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaControllerImpl(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @Override
    public Empresa criarEmpresa(Empresa empresa) {
        return empresaService.criarEmpresa(empresa);
    }

    @Override
    public Empresa editarEmpresa(int id, Empresa empresa) {
        return empresaService.editarEmpresa(empresa, id);
    }

    @Override
    public void deletarEmpresa(int id) {
        empresaService.deletarEmpresa(id);
    }

    @Override
    public Empresa buscarPorId(int id) {
        return empresaService.listarById(id).getFirst();
    }

    @Override
    public List<Empresa> listarEmpresas() {
        return empresaService.listarEmpresas();
    }

    @Override
    public Empresa login(String cnpj, String senha) {
        return empresaService.login(cnpj, senha);
    }
}
