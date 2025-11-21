package com.economy.dto.input;

import java.math.BigDecimal;
import java.util.Date;

public class EmpresaInputDto {
    private String nome;
    private String cnpj;
    private BigDecimal saldo;
    private String senha;

    public EmpresaInputDto( String nome, String cnpj, BigDecimal saldo, Date dataCriacao) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.saldo = saldo;
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

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }
}
