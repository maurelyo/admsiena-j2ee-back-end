package com.br.siena.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_espaco", schema = "admin", catalog = "siena")
public class EspacoEntity {
    private Integer idEspaco;
    private String noEspaco;
    private Boolean inAtivo;
    private Serializable nuValorAluguel;

    @Id
    @Column(name = "id_espaco")
    public Integer getIdEspaco() {
        return idEspaco;
    }

    public void setIdEspaco(Integer idEspaco) {
        this.idEspaco = idEspaco;
    }

    @Basic
    @Column(name = "no_espaco")
    public String getNoEspaco() {
        return noEspaco;
    }

    public void setNoEspaco(String noEspaco) {
        this.noEspaco = noEspaco;
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
    @Column(name = "nu_valor_aluguel")
    public Serializable getNuValorAluguel() {
        return nuValorAluguel;
    }

    public void setNuValorAluguel(Serializable nuValorAluguel) {
        this.nuValorAluguel = nuValorAluguel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EspacoEntity that = (EspacoEntity) o;
        return Objects.equals(idEspaco, that.idEspaco) &&
                Objects.equals(noEspaco, that.noEspaco) &&
                Objects.equals(inAtivo, that.inAtivo) &&
                Objects.equals(nuValorAluguel, that.nuValorAluguel);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idEspaco, noEspaco, inAtivo, nuValorAluguel);
    }
}
