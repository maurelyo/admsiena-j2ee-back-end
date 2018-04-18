package com.br.siena.domain;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tb_reserva", schema = "admin", catalog = "siena")
public class ReservaEntity {
    private Integer idReserva;
    private Timestamp dtAlteracao;
    private Boolean inPago;
    private Boolean inAtivo;
    private Date dtReserva;

    @Id
    @Column(name = "id_reserva")
    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
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
    @Column(name = "in_pago")
    public Boolean getInPago() {
        return inPago;
    }

    public void setInPago(Boolean inPago) {
        this.inPago = inPago;
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
    @Column(name = "dt_reserva")
    public Date getDtReserva() {
        return dtReserva;
    }

    public void setDtReserva(Date dtReserva) {
        this.dtReserva = dtReserva;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservaEntity that = (ReservaEntity) o;
        return Objects.equals(idReserva, that.idReserva) &&
                Objects.equals(dtAlteracao, that.dtAlteracao) &&
                Objects.equals(inPago, that.inPago) &&
                Objects.equals(inAtivo, that.inAtivo) &&
                Objects.equals(dtReserva, that.dtReserva);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idReserva, dtAlteracao, inPago, inAtivo, dtReserva);
    }
}
