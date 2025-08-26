package com.gestaofinanceirapessoal.domains;

import com.gestaofinanceirapessoal.domains.dtos.ContaDTO;
import com.gestaofinanceirapessoal.domains.enums.TipoConta;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contas")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_conta")
    @SequenceGenerator(name = "seq_conta", sequenceName = "seq_conta", allocationSize = 1)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;

    private Integer limite;
    private Double saldo;
    private Integer agencia;
    private Integer numero;

    @ManyToOne
    @JoinColumn(name = "banco_id")
    private Banco banco;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transacao> transacoes = new ArrayList<>();

    public Conta() {}

    public Conta(Long id, TipoConta tipoConta, Integer limite, Double saldo, Integer agencia, Integer numero, Banco banco, Usuario usuario) {
        this.id = id;
        this.tipoConta = tipoConta;
        this.limite = limite;
        this.saldo = saldo;
        this.agencia = agencia;
        this.numero = numero;
        this.banco = banco;
        this.usuario = usuario;
    }

    public Conta(ContaDTO dto) {
        this.id = dto.getId();
        this.tipoConta = dto.getTipoConta();
        this.limite = dto.getLimite();
        this.saldo = dto.getSaldo();
        this.agencia = dto.getAgencia();
        this.numero = dto.getNumero();
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

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }
}
