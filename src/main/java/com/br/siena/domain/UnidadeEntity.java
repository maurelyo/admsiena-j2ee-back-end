package com.br.siena.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tb_unidade", schema = "admin", catalog = "siena")
public class UnidadeEntity {
    private Integer idUnidade;
    private String sgBloco;
    private Integer nuApartamento;
    private Boolean inAtivo;
    private Timestamp dtAlteracao;
    private BigDecimal nuTamanho;

    @Id
    @Column(name = "id_unidade")
    public Integer getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(Integer idUnidade) {
        this.idUnidade = idUnidade;
    }

    @Basic
    @Column(name = "sg_bloco")
    public String getSgBloco() {
        return sgBloco;
    }

    public void setSgBloco(String sgBloco) {
        this.sgBloco = sgBloco;
    }

    @Basic
    @Column(name = "nu_apartamento")
    public Integer getNuApartamento() {
        return nuApartamento;
    }

    public void setNuApartamento(Integer nuApartamento) {
        this.nuApartamento = nuApartamento;
    }

    @Basic
    @Column(name = "in_ativo")
    public Boolean getInAtivo() {
        return inAtivo;
    }

    public void setInAtivo(Boolean inAtivo) {
        this.inAtivo = inAtivo;
    }

    @Basic
    @Column(name = "dt_alteracao")
    public Timestamp getDtAlteracao() {
        return dtAlteracao;
    }

    public void setDtAlteracao(Timestamp dtAlteracao) {
        this.dtAlteracao = dtAlteracao;
    }

    @Basic
    @Column(name = "nu_tamanho")
    public BigDecimal getNuTamanho() {
        return nuTamanho;
    }

    public void setNuTamanho(BigDecimal nuTamanho) {
        this.nuTamanho = nuTamanho;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnidadeEntity that = (UnidadeEntity) o;
        return Objects.equals(idUnidade, that.idUnidade) &&
                Objects.equals(sgBloco, that.sgBloco) &&
                Objects.equals(nuApartamento, that.nuApartamento) &&
                Objects.equals(inAtivo, that.inAtivo) &&
                Objects.equals(dtAlteracao, that.dtAlteracao) &&
                Objects.equals(nuTamanho, that.nuTamanho);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idUnidade, sgBloco, nuApartamento, inAtivo, dtAlteracao, nuTamanho);
    }
}
