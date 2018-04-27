package com.br.siena.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tb_unidade", schema = "admin", catalog = "siena")
public class UnidadeEntity {

    @Id
    @Column(name = "id_unidade", nullable = false)
    @SequenceGenerator(name = "tb_unidade_id_unidade_seq",
            sequenceName = "admin.tb_unidade_id_unidade_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_unidade_id_unidade_seq")
    private int idUnidade;

    @Basic
    @Column(name = "sg_bloco", nullable = false)
    private String sgBloco;

    @Basic
    @Column(name = "nu_apartamento", nullable = false)
    private int nuApartamento;

    @Basic
    @Column(name = "in_ativo", nullable = false)
    private boolean inAtivo;

    @Basic
    @Column(name = "dt_alteracao", nullable = false)
    private Timestamp dtAlteracao;

    @Basic
    @Column(name = "nu_tamanho", nullable = false)
    private BigDecimal nuTamanho;

    public int getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(int idUnidade) {
        this.idUnidade = idUnidade;
    }

    public String getSgBloco() {
        return sgBloco;
    }

    public void setSgBloco(String sgBloco) {
        this.sgBloco = sgBloco;
    }

    public int getNuApartamento() {
        return nuApartamento;
    }

    public void setNuApartamento(int nuApartamento) {
        this.nuApartamento = nuApartamento;
    }

    public boolean isInAtivo() {
        return inAtivo;
    }

    public void setInAtivo(boolean inAtivo) {
        this.inAtivo = inAtivo;
    }

    public Timestamp getDtAlteracao() {
        return dtAlteracao;
    }

    public void setDtAlteracao(Timestamp dtAlteracao) {
        this.dtAlteracao = dtAlteracao;
    }

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
