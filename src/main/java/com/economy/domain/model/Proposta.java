package com.economy.domain.model;

import java.math.BigDecimal;
import java.util.Date;

public class Proposta {
    private int id;
    private int empresaId;
    private String descricao;
    private BigDecimal valor;
    private Date dataCriacao;
    private int empregadoId;
    private boolean isLongoPrazo;
    private String status;

    public Proposta(int id, int empresaId, String descricao, BigDecimal valor, Date dataCriacao, int empregadoId, boolean isLongoPrazo, String status) {
        this.id = id;
        this.empresaId = empresaId;
        this.descricao = descricao;
        this.valor = valor;
        this.dataCriacao = dataCriacao;
        this.empregadoId = empregadoId;
        this.isLongoPrazo = isLongoPrazo;
        this.status = status;
    }

    public Proposta() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public int getEmpregadoId() {
        return empregadoId;
    }

    public void setEmpregadoId(int empregadoId) {
        this.empregadoId = empregadoId;
    }

    public boolean isLongoPrazo() {
        return isLongoPrazo;
    }

    public void setLongoPrazo(boolean longoPrazo) {
        isLongoPrazo = longoPrazo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
