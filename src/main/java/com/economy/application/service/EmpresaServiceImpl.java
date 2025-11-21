package com.economy.application.service;

import com.economy.domain.model.Empresa;
import com.economy.domain.repository.EmpresaRepository;
import com.economy.domain.service.EmpresaService;

import java.util.List;

public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaServiceImpl(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @Override
    public Empresa criarEmpresa(Empresa empresa) {
        return empresaRepository.criarEmpresa(empresa);
    }

    @Override
    public Empresa editarEmpresa(Empresa empresa, int idEmpresa) {
        return empresaRepository.editarEmpresa(empresa, idEmpresa);
    }

    @Override
    public void deletarEmpresa(int idEmpresa) {
        empresaRepository.deletarEmpresa(idEmpresa);
    }

    @Override
    public List<Empresa> listarEmpresas() {
        return empresaRepository.listarEmpresas();
    }

    @Override
    public List<Empresa> listarById(int id) {
        return empresaRepository.listarById(id);
    }

    @Override
    public Empresa login(String email, String senha) {
        return empresaRepository.login(email, senha);
    }
}
