package com.br.siena.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_espaco", schema = "admin", catalog = "siena")
public class EspacoEntity {

    @Id
    @Column(name = "id_espaco", nullable = false)
    @SequenceGenerator(name = "tb_espaco_id_espaco_seq",
            sequenceName = "admin.tb_espaco_id_espaco_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_espaco_id_espaco_seq")
    private int idEspaco;

    @Basic
    @Column(name = "no_espaco", nullable = false)
    private String noEspaco;

    @Basic
    @Column(name = "in_ativo", nullable = false)
    private boolean inAtivo;

    @Basic
    @Column(name = "nu_valor_aluguel", nullable = false)
    private String nuValorAluguel;

    public int getIdEspaco() {
        return idEspaco;
    }

    public void setIdEspaco(int idEspaco) {
        this.idEspaco = idEspaco;
    }

    public String getNoEspaco() {
        return noEspaco;
    }

    public void setNoEspaco(String noEspaco) {
        this.noEspaco = noEspaco;
    }

    public boolean isInAtivo() {
        return inAtivo;
    }

    public void setInAtivo(boolean inAtivo) {
        this.inAtivo = inAtivo;
    }

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
