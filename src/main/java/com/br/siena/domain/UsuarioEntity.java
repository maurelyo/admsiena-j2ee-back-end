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
    private PerfilEntity perfil;
    private String noSenha;
    private String noEmail;
    private PessoaEntity pessoa;

    @Id
    @Column(name = "id_usuario")
    @SequenceGenerator(name = "tb_usuario_id_usuario_seq",
            sequenceName = "admin.tb_usuario_id_usuario_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_usuario_id_usuario_seq")
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

    @ManyToOne
    @JoinColumn(name = "id_perfil")
    public PerfilEntity getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilEntity perfil) {
        this.perfil = perfil;
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

    @OneToOne
    @JoinColumn(name = "id_pessoa")
    public PessoaEntity getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaEntity pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioEntity)) return false;
        UsuarioEntity that = (UsuarioEntity) o;
        return getIdUsuario() == that.getIdUsuario() &&
                isInAtivo() == that.isInAtivo() &&
                Objects.equals(getNoLogin(), that.getNoLogin()) &&
                Objects.equals(getDtAlteracao(), that.getDtAlteracao()) &&
                Objects.equals(getPerfil(), that.getPerfil()) &&
                Objects.equals(getNoSenha(), that.getNoSenha()) &&
                Objects.equals(getNoEmail(), that.getNoEmail()) &&
                Objects.equals(getPessoa(), that.getPessoa());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdUsuario(), getNoLogin(), getDtAlteracao(), isInAtivo(), getPerfil(), getNoSenha(), getNoEmail(), getPessoa());
    }
}
