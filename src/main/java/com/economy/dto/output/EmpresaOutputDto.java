package com.economy.dto.output;

import java.math.BigDecimal;
import java.util.Date;

public class EmpresaOutputDto {
    private int id;
    private String nome;
    private String cnpj;
    private BigDecimal saldo;
    private Date dataCriacao;

    public EmpresaOutputDto(int id, String nome, String cnpj, BigDecimal saldo, Date dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.saldo = saldo;
        this.dataCriacao = dataCriacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
