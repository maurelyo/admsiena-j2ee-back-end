package com.br.siena.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_perfil", schema = "admin", catalog = "siena")
public class PerfilEntity {
    private Integer idPerfil;
    private String noPerfil;
    private Boolean inAtivo;

    @Id
    @Column(name = "id_perfil")
    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    @Basic
    @Column(name = "no_perfil")
    public String getNoPerfil() {
        return noPerfil;
    }

    public void setNoPerfil(String noPerfil) {
        this.noPerfil = noPerfil;
    }

    @Basic
    @Column(name = "in_ativo")
    public Boolean getInAtivo() {
        return inAtivo;
    }

    public void setInAtivo(Boolean inAtivo) {
        this.inAtivo = inAtivo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PerfilEntity that = (PerfilEntity) o;
        return Objects.equals(idPerfil, that.idPerfil) &&
                Objects.equals(noPerfil, that.noPerfil) &&
                Objects.equals(inAtivo, that.inAtivo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idPerfil, noPerfil, inAtivo);
    }
}
