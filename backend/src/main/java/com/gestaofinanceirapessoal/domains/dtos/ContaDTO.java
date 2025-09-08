package com.gestaofinanceirapessoal.domains.dtos;

import com.gestaofinanceirapessoal.domains.Conta;
import com.gestaofinanceirapessoal.domains.enums.TipoConta;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public class ContaDTO {

    private Long id;

    @NotNull(message = "O campo Tipo de Conta não pode ser nulo")
    private TipoConta tipoConta;

    private Integer limite;
    private Double saldo;
    private Integer agencia;
    private Integer numero;
    
    private Long bancoId;
    private Long usuarioId;
    private List<Long> transacoesIds;

    public ContaDTO() {}

    public ContaDTO(Conta conta) {
        this.id = conta.getId();
        this.tipoConta = conta.getTipoConta();
        this.limite = conta.getLimite();
        this.saldo = conta.getSaldo();
        this.agencia = conta.getAgencia();
        this.numero = conta.getNumero();
        this.bancoId = conta.getBanco() != null ? conta.getBanco().getId() : null;
        this.usuarioId = conta.getUsuario() != null ? conta.getUsuario().getId() : null;
        this.transacoesIds = conta.getTransacoes().stream()
                .map(transacao -> transacao.getId())
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Integer getLimite() {
        return limite;
    }

    public void setLimite(Integer limite) {
        this.limite = limite;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Long getBancoId() {
        return bancoId;
    }

    public void setBancoId(Long bancoId) {
        this.bancoId = bancoId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<Long> getTransacoesIds() {
        return transacoesIds;
    }

    public void setTransacoesIds(List<Long> transacoesIds) {
        this.transacoesIds = transacoesIds;
    }
}
