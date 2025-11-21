package com.economy.dto.input;

import java.math.BigDecimal;

public class PixDepositInputDto {
    private BigDecimal valor;
    private String descricao;
    private String email;
    private String nome;
    private String cnpj;

    public PixDepositInputDto(BigDecimal valor, String descricao, String email, String nome, String cnpj) {
        this.valor = valor;
        this.descricao = descricao;
        this.email = email;
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
