package com.economy.domain.model;

import java.math.BigDecimal;
import java.util.Date;

public class Saque {
    private int id;
    private int empregadoId;
    private BigDecimal valor;
    private String metodo;
    private Date dataSaque;

    public Saque() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public Date getDataSaque() {
        return dataSaque;
    }

    public void setDataSaque(Date dataSaque) {
        this.dataSaque = dataSaque;
    }

    public Saque(int id, int empregadoId, BigDecimal valor, String metodo, Date dataSaque) {
        this.id = id;
        this.empregadoId = empregadoId;
        this.valor = valor;
        this.metodo = metodo;
        this.dataSaque = dataSaque;
    }
}
