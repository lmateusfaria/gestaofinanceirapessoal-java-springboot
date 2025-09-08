package com.gestaofinanceirapessoal.domains.dtos;

import com.gestaofinanceirapessoal.domains.CentroCusto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CentroCustoDTO {

    private Long id;

    @NotNull(message = "O campo descrição não pode ser nulo")
    @NotBlank(message = "O campo descrição não pode ser vazio")
    private String descricao;

    private Integer valorLimite;

    private Long usuarioId;
    private List<Long> transacoesIds = new ArrayList<>();

    public CentroCustoDTO() {}

    public CentroCustoDTO(CentroCusto centroCusto) {
        this.id = centroCusto.getId();
        this.descricao = centroCusto.getDescricao();
        this.valorLimite = centroCusto.getValorLimite();
        this.usuarioId = centroCusto.getUsuario() != null ? centroCusto.getUsuario().getId() : null;
        this.transacoesIds = centroCusto.getTransacoes().stream()
                .map(transacao -> transacao.getId())
                .collect(Collectors.toList());
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
