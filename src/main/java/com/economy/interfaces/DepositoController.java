package com.economy.interfaces;

import com.economy.domain.model.Deposito;
import com.economy.dto.input.PixDepositInputDto;
import com.economy.dto.output.PixQrCodeOutputDto;

import java.util.List;

public interface DepositoController {
    PixQrCodeOutputDto createPixQr(PixDepositInputDto deposito);
    Deposito fazerDeposito(Deposito deposito);
    List<Deposito> listarDepositosPorEmpresa(int empresaId);
}
