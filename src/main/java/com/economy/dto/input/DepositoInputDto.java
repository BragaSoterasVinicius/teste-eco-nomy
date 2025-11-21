package com.economy.dto.input;

import java.math.BigDecimal;
import java.util.Date;

public class DepositoInputDto {
    private int empresaId;
    private BigDecimal valor;
    private String origem;

    public DepositoInputDto(int empresaId, BigDecimal valor, String origem, Date dateDeposito) {
        this.empresaId = empresaId;
        this.valor = valor;
        this.origem = origem;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
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

}
