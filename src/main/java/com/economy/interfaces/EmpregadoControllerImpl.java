package com.economy.interfaces;

import com.economy.domain.model.Empregado;
import com.economy.domain.service.EmpregadoService;
import java.util.List;

public class EmpregadoControllerImpl implements EmpregadoController {

    private final EmpregadoService empregadoService;

    public EmpregadoControllerImpl(EmpregadoService empregadoService) {
        this.empregadoService = empregadoService;
    }

    @Override
    public Empregado criarEmpregado(Empregado empregado) {
        return empregadoService.criarEmpregado(empregado);
    }

    @Override
    public Empregado editarEmpregado(int id, Empregado empregado) {
        return empregadoService.editarEmpregado(id, empregado);
    }

    @Override
    public void deletarEmpregado(int id) {
        empregadoService.deletarEmpregado(id);
    }

    @Override
    public Empregado buscarPorId(int id) {
        return empregadoService.buscarPorId(id);
    }

    @Override
    public List<Empregado> listarEmpregados() {
        return empregadoService.listarEmpregados();
    }

    @Override
    public Empregado loginEmpregado(String email, String senha) {
        return empregadoService.loginEmpregado(email, senha);
    }
}
