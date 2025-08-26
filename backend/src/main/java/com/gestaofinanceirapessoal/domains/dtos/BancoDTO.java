package com.gestaofinanceirapessoal.domains.dtos;

import com.gestaofinanceirapessoal.domains.Banco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BancoDTO {

    private Long id;

    @NotNull(message = "O campo CNPJ não pode ser nulo")
    @NotBlank(message = "O campo CNPJ não pode ser vazio")
    private String cnpj;

    @NotNull(message = "O campo Razão Social não pode ser nulo")
    @NotBlank(message = "O campo Razão Social não pode ser vazio")
    private String razaoSocial;

    public BancoDTO() {}

    public BancoDTO(Banco banco) {
        this.id = banco.getId();
        this.cnpj = banco.getCnpj();
        this.razaoSocial = banco.getRazaoSocial();
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
}
