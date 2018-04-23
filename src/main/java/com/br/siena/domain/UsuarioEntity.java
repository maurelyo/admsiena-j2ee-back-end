package com.br.siena.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tb_usuario", schema = "admin", catalog = "siena")
public class UsuarioEntity {
    private Integer idUsuario;
    private String noLogin;
    private String noPessoa;
    private Timestamp dtAlteracao;
    private Boolean inAtivo;
    private String nuCpf;
    private String noSenha;
    private Integer idPerfil;
    private Integer idUnidade;

    @Id
    @Column(name = "id_usuario")
    @SequenceGenerator(name = "tb_usuario_id_usuario_seq",
            sequenceName = "admin.tb_usuario_id_usuario_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_usuario_id_usuario_seq")
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Basic
    @Column(name = "no_login")
    public String getNoLogin() {
        return noLogin;
    }

    public void setNoLogin(String noLogin) {
        this.noLogin = noLogin;
    }

    @Basic
    @Column(name = "no_pessoa")
    public String getNoPessoa() {
        return noPessoa;
    }

    public void setNoPessoa(String noPessoa) {
        this.noPessoa = noPessoa;
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
    @Column(name = "in_ativo")
    public Boolean getInAtivo() {
        return inAtivo;
    }

    public void setInAtivo(Boolean inAtivo) {
        this.inAtivo = inAtivo;
    }
    @Basic
    @Column(name = "id_perfil")
    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }
    @Basic
    @Column(name = "id_unidade")
    public Integer getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(Integer idUnidade) {
        this.idUnidade = idUnidade;
    }

    @Basic
    @Column(name = "nu_cpf")
    public String getNuCpf() {
        return nuCpf;
    }

    public void setNuCpf(String nuCpf) {
        this.nuCpf = nuCpf;
    }


    @Basic
    @Column(name = "no_senha")
    public String getNoSenha() {
        return noSenha;
    }

    public void setNoSenha(String noSenha) {
        this.noSenha = noSenha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioEntity that = (UsuarioEntity) o;
        return Objects.equals(idUsuario, that.idUsuario) &&
                Objects.equals(noLogin, that.noLogin) &&
                Objects.equals(noPessoa, that.noPessoa) &&
                Objects.equals(dtAlteracao, that.dtAlteracao) &&
                Objects.equals(inAtivo, that.inAtivo) &&
                Objects.equals(idPerfil, that.idPerfil) &&
                Objects.equals(idUnidade, that.idUnidade) &&
                Objects.equals(nuCpf, that.nuCpf) &&
                Objects.equals(noSenha, that.noSenha);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idUsuario, noLogin, noPessoa, dtAlteracao, inAtivo, idPerfil, idUnidade, nuCpf, noSenha);
    }
}
