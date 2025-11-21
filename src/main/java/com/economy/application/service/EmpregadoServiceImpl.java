package com.economy.application.service;

import com.economy.domain.model.Empregado;
import com.economy.domain.repository.EmpregadoRepository;
import com.economy.domain.service.EmpregadoService;

import java.util.List;

public class EmpregadoServiceImpl implements EmpregadoService {

    private final EmpregadoRepository empregadoRepository;

    public EmpregadoServiceImpl(EmpregadoRepository empregadoRepository) {
        this.empregadoRepository = empregadoRepository;
    }

    @Override
    public Empregado criarEmpregado(Empregado empregado) {
        return empregadoRepository.criarEmpregado(empregado);
    }

    @Override
    public Empregado editarEmpregado(int id, Empregado empregado) {
        return empregadoRepository.editarEmpregado(empregado, id);
    }

    @Override
    public void deletarEmpregado(int id) {
        empregadoRepository.deletarEmpregado(id);
    }

    @Override
    public Empregado buscarPorId(int id) {
        return empregadoRepository.listarByIdUsuario(id).get(0);
    }

    @Override
    public List<Empregado> listarEmpregados() {
        return empregadoRepository.listarEmpregados();
    }

    @Override
    public Empregado loginEmpregado(String email, String senha) {
        return empregadoRepository.loginEmpregado(email, senha);
    }
}
