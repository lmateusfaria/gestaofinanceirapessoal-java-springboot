package com.gestaofinanceirapessoal.domains.dtos;

import com.gestaofinanceirapessoal.domains.Banco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BancoDTO {

    private Long id;

    @NotNull(message = "O campo CNPJ não pode ser nulo")
    @NotBlank(message = "O campo CNPJ não pode ser vazio")
    private String cnpj;

    @NotNull(message = "O campo Razão Social não pode ser nulo")
    @NotBlank(message = "O campo Razão Social não pode ser vazio")
    private String razaoSocial;

    private List<Long> contasIds = new ArrayList<>();

    public BancoDTO() {}

    public BancoDTO(Banco banco) {
        this.id = banco.getId();
        this.cnpj = banco.getCnpj();
        this.razaoSocial = banco.getRazaoSocial();
        this.contasIds = banco.getContas().stream()
                .map(conta -> conta.getId())
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public List<Long> getContasIds() {
        return contasIds;
    }

    public void setContasIds(List<Long> contasIds) {
        this.contasIds = contasIds;
    }
}
