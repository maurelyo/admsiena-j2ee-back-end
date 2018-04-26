package com.br.siena.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_perfil", schema = "admin", catalog = "siena")
public class PerfilEntity {
    private int idPerfil;
    private String noPerfil;
    private boolean inAtivo;

    @Id
    @Column(name = "id_perfil")
    @SequenceGenerator(name = "tb_perfil_id_perfil_seq",
            sequenceName = "admin.tb_perfil_id_perfil_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_perfil_id_perfil_seq")
    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
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
        PerfilEntity that = (PerfilEntity) o;
        return idPerfil == that.idPerfil &&
                inAtivo == that.inAtivo &&
                Objects.equals(noPerfil, that.noPerfil);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idPerfil, noPerfil, inAtivo);
    }
}
