package com.economy.infrastructure.config;

import com.economy.application.service.*;
import com.economy.domain.repository.*;
import com.economy.domain.service.*;
import com.economy.interfaces.DepositoControllerImpl;
import com.economy.interfaces.SaqueControllerImpl;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ServiceConfig {

    @ApplicationScoped
    public DepositoService depositoService(DepositoRepository depositoRepository) {
        return new DepositoServiceImpl(depositoRepository);
    }

    @ApplicationScoped
    public SaqueService saqueService(SaqueRepository saqueRepository) {
        return new SaqueServiceImpl(saqueRepository);
    }

    @ApplicationScoped
    public EmpregadoService empregadoService(EmpregadoRepository empregadoRepository) {
        return new EmpregadoServiceImpl(empregadoRepository);
    }

    @ApplicationScoped
    public EmpresaService empresaService(EmpresaRepository empresaRepository) {
        return new EmpresaServiceImpl(empresaRepository);
    }

    @ApplicationScoped
    public PagamentoService pagamentoService(PagamentoRepository pagamentoRepository) {
        return new PagamentoServiceImpl(pagamentoRepository);
    }

    @ApplicationScoped
    public PropostaService propostaService(PropostaRepository propostaRepository) {
        return new PropostaServiceImpl(propostaRepository);
    }
}
