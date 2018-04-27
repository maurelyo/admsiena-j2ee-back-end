package com.br.siena.domain;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tb_pessoa", schema = "admin", catalog = "siena")
public class PessoaEntity {

    @Id
    @Column(name = "id_pessoa")
    @SequenceGenerator(name = "tb_pessoa_id_pessoa_seq",
            sequenceName = "admin.tb_pessoa_id_pessoa_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_pessoa_id_pessoa_seq")
    private int idPessoa;

    @Basic
    @Column(name = "no_pessoa", nullable = false)
    private String noPessoa;

    @CPF
    @Basic
    @Column(name = "nu_cpf")
    private String nuCpf;

    @Basic
    @Column(name = "nu_rg")
    private String nuRg;

    @Basic
    @Column(name = "in_ativo", nullable = false)
    private boolean inAtivo;

    @Basic
    @Column(name = "dt_alteracao", nullable = false)
    private Timestamp dtAlteracao;

    @Basic
    @Column(name = "dt_nascimento")
    private Date dtNascimento;

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNoPessoa() {
        return noPessoa;
    }

    public void setNoPessoa(String noPessoa) {
        this.noPessoa = noPessoa;
    }

    public String getNuCpf() {
        return nuCpf;
    }

    public void setNuCpf(String nuCpf) {
        this.nuCpf = nuCpf;
    }

    public String getNuRg() {
        return nuRg;
    }

    public void setNuRg(String nuRg) {
        this.nuRg = nuRg;
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

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PessoaEntity that = (PessoaEntity) o;
        return idPessoa == that.idPessoa &&
                inAtivo == that.inAtivo &&
                Objects.equals(noPessoa, that.noPessoa) &&
                Objects.equals(nuCpf, that.nuCpf) &&
                Objects.equals(nuRg, that.nuRg) &&
                Objects.equals(dtAlteracao, that.dtAlteracao) &&
                Objects.equals(dtNascimento, that.dtNascimento);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idPessoa, noPessoa, nuCpf, nuRg, inAtivo, dtAlteracao, dtNascimento);
    }
}
