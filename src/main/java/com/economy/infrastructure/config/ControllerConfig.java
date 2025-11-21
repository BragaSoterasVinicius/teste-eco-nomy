package com.economy.infrastructure.config;

import com.economy.domain.service.*;
import com.economy.interfaces.*;
import jakarta.enterprise.context.ApplicationScoped;

public class ControllerConfig {

    @ApplicationScoped
    public DepositoController depositoController(DepositoService depositoController, PixService pixService) {
        return new DepositoControllerImpl(depositoController, pixService);
    }

    @ApplicationScoped
    public EmpregadoController empregadoController(EmpregadoService empregadoController) {
        return new EmpregadoControllerImpl(empregadoController);
    }

    @ApplicationScoped
    public EmpresaController empresaController(EmpresaService empresaController) {
        return new EmpresaControllerImpl(empresaController);
    }

    @ApplicationScoped
    public PagamentoController pagamentoController(PagamentoService pagamentoController) {
        return new PagamentoControllerImpl(pagamentoController);
    }

    @ApplicationScoped
    public PropostaController propostaController(PropostaService propostaController) {
        return new PropostaControllerImpl(propostaController);
    }

    @ApplicationScoped
    public SaqueController saqueController(SaqueService saqueController) {
        return new SaqueControllerImpl(saqueController);
    }
}
