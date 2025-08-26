package com.gestaofinanceirapessoal.domains.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gestaofinanceirapessoal.domains.Transacao;
import com.gestaofinanceirapessoal.domains.enums.Status;
import com.gestaofinanceirapessoal.domains.enums.TipoTransacao;

import java.time.LocalDate;

public class TransacaoDTO {

    private Long id;
    private String descricao;
    private Double parcela;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataTransacao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataVencimento;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataBaixa;

    private Double valorDocumento;
    private TipoTransacao tipoTransacao;
    private Status status;

    public TransacaoDTO() {}

    public TransacaoDTO(Transacao transacao) {
        this.id = transacao.getId();
        this.descricao = transacao.getDescricao();
        this.parcela = transacao.getParcela();
        this.dataTransacao = transacao.getDataTransacao();
        this.dataVencimento = transacao.getDataVencimento();
        this.dataBaixa = transacao.getDataBaixa();
        this.valorDocumento = transacao.getValorDocumento();
        this.tipoTransacao = transacao.getTipoTransacao();
        this.status = transacao.getStatus();
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

    public Double getParcela() {
        return parcela;
    }

    public void setParcela(Double parcela) {
        this.parcela = parcela;
    }

    public LocalDate getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(LocalDate dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataBaixa() {
        return dataBaixa;
    }

    public void setDataBaixa(LocalDate dataBaixa) {
        this.dataBaixa = dataBaixa;
    }

    public Double getValorDocumento() {
        return valorDocumento;
    }

    public void setValorDocumento(Double valorDocumento) {
        this.valorDocumento = valorDocumento;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
