package com.br.siena.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tb_unidade", schema = "admin", catalog = "siena")
public class UnidadeEntity {
    private int idUnidade;
    private String sgBloco;
    private int nuApartamento;
    private boolean inAtivo;
    private Timestamp dtAlteracao;
    private BigDecimal nuTamanho;

    @Id
    @Column(name = "id_unidade")
    public int getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(int idUnidade) {
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
    public int getNuApartamento() {
        return nuApartamento;
    }

    public void setNuApartamento(int nuApartamento) {
        this.nuApartamento = nuApartamento;
    }

    @Basic
    @Column(name = "in_ativo")
    public boolean isInAtivo() {
        return inAtivo;
    }

    public void setInAtivo(boolean inAtivo) {
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
        return idUnidade == that.idUnidade &&
                nuApartamento == that.nuApartamento &&
                inAtivo == that.inAtivo &&
                Objects.equals(sgBloco, that.sgBloco) &&
                Objects.equals(dtAlteracao, that.dtAlteracao) &&
                Objects.equals(nuTamanho, that.nuTamanho);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idUnidade, sgBloco, nuApartamento, inAtivo, dtAlteracao, nuTamanho);
    }
}
