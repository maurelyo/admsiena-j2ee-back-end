package com.br.siena.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tb_usuario", schema = "admin", catalog = "siena")
public class UsuarioEntity {
    private int idUsuario;
    private String noLogin;
    private Timestamp dtAlteracao;
    private boolean inAtivo;
    private String noSenha;
    private String noEmail;

    @Id
    @Column(name = "id_usuario")
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
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
    @Column(name = "dt_alteracao")
    public Timestamp getDtAlteracao() {
        return dtAlteracao;
    }

    public void setDtAlteracao(Timestamp dtAlteracao) {
        this.dtAlteracao = dtAlteracao;
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
    @Column(name = "no_senha")
    public String getNoSenha() {
        return noSenha;
    }

    public void setNoSenha(String noSenha) {
        this.noSenha = noSenha;
    }

    @Basic
    @Column(name = "no_email")
    public String getNoEmail() {
        return noEmail;
    }

    public void setNoEmail(String noEmail) {
        this.noEmail = noEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioEntity that = (UsuarioEntity) o;
        return idUsuario == that.idUsuario &&
                inAtivo == that.inAtivo &&
                Objects.equals(noLogin, that.noLogin) &&
                Objects.equals(dtAlteracao, that.dtAlteracao) &&
                Objects.equals(noSenha, that.noSenha) &&
                Objects.equals(noEmail, that.noEmail);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idUsuario, noLogin, dtAlteracao, inAtivo, noSenha, noEmail);
    }
}
