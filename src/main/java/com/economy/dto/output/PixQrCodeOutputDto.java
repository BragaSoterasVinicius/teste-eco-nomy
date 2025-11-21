package com.economy.dto.output;

import java.math.BigDecimal;

public class PixQrCodeOutputDto {
    private BigDecimal valor;
    private String origem;
    private String qrCode;
    private String qrCode64;

    public PixQrCodeOutputDto(BigDecimal valor, String origem, String qrCode, String qrCode64) {
        this.valor = valor;
        this.origem = origem;
        this.qrCode = qrCode;
        this.qrCode64 = qrCode64;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getQrCode64() {
        return qrCode64;
    }

    public void setQrCode64(String qrCode64) {
        this.qrCode64 = qrCode64;
    }
}
