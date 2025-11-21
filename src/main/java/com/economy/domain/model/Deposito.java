package com.economy.domain.model;

import java.math.BigDecimal;
import java.util.Date;

public class Deposito {
    private int id;
    private int empresaId;
    private BigDecimal valor;
    private String origem;
    private Date dateDeposito;

    public Deposito(int id, int empresaId, BigDecimal valor, String origem, Date dateDeposito) {
        this.id = id;
        this.empresaId = empresaId;
        this.valor = valor;
        this.origem = origem;
        this.dateDeposito = dateDeposito;
    }

    public Deposito() {

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

    public Date getDateDeposito() {
        return dateDeposito;
    }

    public void setDateDeposito(Date dateDeposito) {
        this.dateDeposito = dateDeposito;
    }
}
