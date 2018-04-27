package com.br.siena.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tb_usuario", schema = "admin", catalog = "siena")
public class UsuarioEntity {

    @Id
    @Column(name = "id_usuario")
    @SequenceGenerator(name = "tb_usuario_id_usuario_seq",
            sequenceName = "admin.tb_usuario_id_usuario_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_usuario_id_usuario_seq")
    private int idUsuario;

    @Basic
    @Column(name = "dt_alteracao", nullable = false)
    private Timestamp dtAlteracao;

    @Basic
    @Column(name = "in_ativo", nullable = false)
    private boolean inAtivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_perfil", nullable = false)
    private PerfilEntity perfil;

    @Basic
    @Column(name = "no_senha", nullable = false)
    private String noSenha;

    @Basic
    @Column(name = "no_email", nullable = false)
    private String noEmail;

    @OneToOne
    @JoinColumn(name = "id_pessoa", nullable = false)
    private PessoaEntity pessoa;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Timestamp getDtAlteracao() {
        return dtAlteracao;
    }

    public void setDtAlteracao(Timestamp dtAlteracao) {
        this.dtAlteracao = dtAlteracao;
    }

    public boolean isInAtivo() {
        return inAtivo;
    }

    public void setInAtivo(boolean inAtivo) {
        this.inAtivo = inAtivo;
    }


    public PerfilEntity getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilEntity perfil) {
        this.perfil = perfil;
    }

    public String getNoSenha() {
        return noSenha;
    }

    public void setNoSenha(String noSenha) {
        this.noSenha = noSenha;
    }

    public String getNoEmail() {
        return noEmail;
    }

    public void setNoEmail(String noEmail) {
        this.noEmail = noEmail;
    }

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
                Objects.equals(getDtAlteracao(), that.getDtAlteracao()) &&
                Objects.equals(getPerfil(), that.getPerfil()) &&
                Objects.equals(getNoSenha(), that.getNoSenha()) &&
                Objects.equals(getNoEmail(), that.getNoEmail()) &&
                Objects.equals(getPessoa(), that.getPessoa());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdUsuario(), getDtAlteracao(), isInAtivo(), getPerfil(), getNoSenha(), getNoEmail(), getPessoa());
    }
}
