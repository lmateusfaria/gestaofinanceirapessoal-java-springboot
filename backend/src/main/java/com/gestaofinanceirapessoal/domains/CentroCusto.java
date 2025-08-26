package com.gestaofinanceirapessoal.domains;

import com.gestaofinanceirapessoal.domains.dtos.CentroCustoDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "centros_custo")
public class CentroCusto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_centro_custo")
    @SequenceGenerator(name = "seq_centro_custo", sequenceName = "seq_centro_custo", allocationSize = 1)
    private Long id;

    private String descricao;
    private Integer valorLimite;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "centroCusto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transacao> transacoes = new ArrayList<>();

    public CentroCusto() {}

    public CentroCusto(Long id, String descricao, Integer valorLimite, Usuario usuario) {
        this.id = id;
        this.descricao = descricao;
        this.valorLimite = valorLimite;
        this.usuario = usuario;
    }

    public CentroCusto(CentroCustoDTO dto) {
        this.id = dto.getId();
        this.descricao = dto.getDescricao();
        this.valorLimite = dto.getValorLimite();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getValorLimite() {
        return valorLimite;
    }

    public void setValorLimite(Integer valorLimite) {
        this.valorLimite = valorLimite;
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
