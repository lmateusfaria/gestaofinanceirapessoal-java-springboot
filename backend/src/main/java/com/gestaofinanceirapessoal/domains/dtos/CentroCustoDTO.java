package com.gestaofinanceirapessoal.domains.dtos;

import com.gestaofinanceirapessoal.domains.CentroCusto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CentroCustoDTO {

    private Long id;

    @NotNull(message = "O campo descrição não pode ser nulo")
    @NotBlank(message = "O campo descrição não pode ser vazio")
    private String descricao;

    private Integer valorLimite;

    public CentroCustoDTO() {}

    public CentroCustoDTO(CentroCusto centroCusto) {
        this.id = centroCusto.getId();
        this.descricao = centroCusto.getDescricao();
        this.valorLimite = centroCusto.getValorLimite();
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
}
