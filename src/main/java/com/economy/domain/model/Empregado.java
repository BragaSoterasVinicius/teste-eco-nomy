package com.economy.domain.model;

import java.math.BigDecimal;
import java.util.Date;

public class Empregado {
    private int empregadoId;
    private String cpf;
    private String nome;
    private String email;
    private BigDecimal saldo;
    private Date dataCriacao;
    private String senha;

    public Empregado(int empregadoId, String cpf, String nome, String email, BigDecimal saldo, Date dataCriacao, String senha) {
        this.empregadoId = empregadoId;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.saldo = saldo;
        this.dataCriacao = dataCriacao;
        this.senha = senha;
    }

    public Empregado() {

    }

    public int getEmpregadoId() {
        return empregadoId;
    }

    public void setEmpregadoId(int empregadoId) {
        this.empregadoId = empregadoId;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
