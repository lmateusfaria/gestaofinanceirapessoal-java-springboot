package com.gestaofinanceirapessoal.domains;

import com.gestaofinanceirapessoal.domains.dtos.BancoDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bancos")
public class Banco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_banco")
    @SequenceGenerator(name = "seq_banco", sequenceName = "seq_banco", allocationSize = 1)
    private Long id;

    @Column(unique = true)
    private String cnpj;

    private String razaoSocial;

    @OneToMany(mappedBy = "banco")
    private List<Conta> contas = new ArrayList<>();

    public Banco() {}

    public Banco(Long id, String cnpj, String razaoSocial) {
        this.id = id;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }

    public Banco(BancoDTO dto) {
        this.id = dto.getId();
        this.cnpj = dto.getCnpj();
        this.razaoSocial = dto.getRazaoSocial();
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

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }
}
