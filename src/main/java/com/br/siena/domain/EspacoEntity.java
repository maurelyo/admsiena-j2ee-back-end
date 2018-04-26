package com.br.siena.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_espaco", schema = "admin", catalog = "siena")
public class EspacoEntity {
    private int idEspaco;
    private String noEspaco;
    private boolean inAtivo;
    private String nuValorAluguel;

    @Id
    @Column(name = "id_espaco")
    @SequenceGenerator(name = "tb_espaco_id_espaco_seq",
            sequenceName = "admin.tb_espaco_id_espaco_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_espaco_id_espaco_seq")
    public int getIdEspaco() {
        return idEspaco;
    }

    public void setIdEspaco(int idEspaco) {
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
    public boolean isInAtivo() {
        return inAtivo;
    }

    public void setInAtivo(boolean inAtivo) {
        this.inAtivo = inAtivo;
    }

    @Basic
    @Column(name = "nu_valor_aluguel")
    public String getNuValorAluguel() {
        return nuValorAluguel;
    }

    public void setNuValorAluguel(String nuValorAluguel) {
        this.nuValorAluguel = nuValorAluguel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EspacoEntity that = (EspacoEntity) o;
        return idEspaco == that.idEspaco &&
                inAtivo == that.inAtivo &&
                Objects.equals(noEspaco, that.noEspaco) &&
                Objects.equals(nuValorAluguel, that.nuValorAluguel);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idEspaco, noEspaco, inAtivo, nuValorAluguel);
    }
}
