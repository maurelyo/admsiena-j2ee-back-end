package com.br.siena.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_tipo_pessoa", schema = "admin", catalog = "siena")
public class TipoPessoaEntity {

    @Id
    @Column(name = "id_tipo_pessoa")
    @SequenceGenerator(name = "tb_tipo_pessoa_id_tipo_pessoa_seq",
            sequenceName = "admin.tb_tipo_pessoa_id_tipo_pessoa_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_tipo_pessoa_id_tipo_pessoa_seq")
    private int idTipoPessoa;

    @Basic
    @Column(name = "no_tipo_pessoa")
    private String noTipoPessoa;

    @Basic
    @Column(name = "in_ativo")
    private boolean inAtivo;

    public int getIdTipoPessoa() {
        return idTipoPessoa;
    }

    public void setIdTipoPessoa(int idTipoPessoa) {
        this.idTipoPessoa = idTipoPessoa;
    }

    public String getNoTipoPessoa() {
        return noTipoPessoa;
    }

    public void setNoTipoPessoa(String noTipoPessoa) {
        this.noTipoPessoa = noTipoPessoa;
    }

    public boolean isInAtivo() {
        return inAtivo;
    }

    public void setInAtivo(boolean inAtivo) {
        this.inAtivo = inAtivo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoPessoaEntity that = (TipoPessoaEntity) o;
        return idTipoPessoa == that.idTipoPessoa &&
                inAtivo == that.inAtivo &&
                Objects.equals(noTipoPessoa, that.noTipoPessoa);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idTipoPessoa, noTipoPessoa, inAtivo);
    }
}
