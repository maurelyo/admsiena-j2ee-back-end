package com.br.siena.domain;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tb_reserva", schema = "admin", catalog = "siena")
public class ReservaEntity {

    @Id
    @Column(name = "id_reserva")
    @SequenceGenerator(name = "tb_reserva_id_reserva_seq",
            sequenceName = "admin.tb_reserva_id_reserva_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_reserva_id_reserva_seq")
    private int idReserva;

    @Basic
    @Column(name = "dt_alteracao")
    private Timestamp dtAlteracao;

    @Basic
    @Column(name = "in_pago")
    private boolean inPago;

    @Basic
    @Column(name = "in_ativo")
    private boolean inAtivo;

    @Basic
    @Column(name = "dt_reserva")
    private Date dtReserva;

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Timestamp getDtAlteracao() {
        return dtAlteracao;
    }

    public void setDtAlteracao(Timestamp dtAlteracao) {
        this.dtAlteracao = dtAlteracao;
    }

    public boolean isInPago() {
        return inPago;
    }

    public void setInPago(boolean inPago) {
        this.inPago = inPago;
    }

    public boolean isInAtivo() {
        return inAtivo;
    }

    public void setInAtivo(boolean inAtivo) {
        this.inAtivo = inAtivo;
    }

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
        return idReserva == that.idReserva &&
                inPago == that.inPago &&
                inAtivo == that.inAtivo &&
                Objects.equals(dtAlteracao, that.dtAlteracao) &&
                Objects.equals(dtReserva, that.dtReserva);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idReserva, dtAlteracao, inPago, inAtivo, dtReserva);
    }
}
