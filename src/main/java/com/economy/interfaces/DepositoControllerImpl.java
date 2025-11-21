package com.economy.interfaces;

import com.economy.domain.model.Deposito;
import com.economy.domain.service.DepositoService;
import com.economy.domain.service.PixService;
import com.economy.dto.input.PixDepositInputDto;
import com.economy.dto.output.PixQrCodeOutputDto;

import java.util.List;

public class DepositoControllerImpl implements DepositoController{
    private final DepositoService depositoService;
    private final PixService pixService;

    public DepositoControllerImpl(DepositoService depositoService, PixService pixService) {
        this.depositoService = depositoService;
        this.pixService = pixService;
    }

    @Override
    public PixQrCodeOutputDto createPixQr(PixDepositInputDto deposito) {
        return pixService.createQrCode(deposito);
    }

    @Override
    public Deposito fazerDeposito(Deposito deposito) {
        return depositoService.criarDeposito(deposito);
    }

    @Override
    public List<Deposito> listarDepositosPorEmpresa(int empresaId) {
        return depositoService.listarByEmpresaId(empresaId);
    }
}
