package com.economy.domain.service;

import com.economy.domain.model.Deposito;
import com.economy.dto.input.PixDepositInputDto;
import com.economy.dto.output.PixQrCodeOutputDto;

public interface PixService {
    PixQrCodeOutputDto createQrCode(PixDepositInputDto deposito);
}
