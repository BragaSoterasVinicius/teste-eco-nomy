package com.economy.dto.input;

import java.math.BigDecimal;
import java.util.Date;

public class PagamentoInputDto {
    private int propostaId;
    private int empresaId;
    private int empregadoId;
    private BigDecimal valor;
    private Date dataPagamento;

    public int getPropostaId() {
        return propostaId;
    }

    public void setPropostaId(int propostaId) {
        this.propostaId = propostaId;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }

    public int getEmpregadoId() {
        return empregadoId;
    }

    public void setEmpregadoId(int empregadoId) {
        this.empregadoId = empregadoId;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public PagamentoInputDto(int propostaId, int empresaId, int empregadoId, BigDecimal valor, Date dataPagamento) {
        this.propostaId = propostaId;
        this.empresaId = empresaId;
        this.empregadoId = empregadoId;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
    }

}
