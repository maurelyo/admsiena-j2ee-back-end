package com.br.siena.domain;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tb_reserva", schema = "admin", catalog = "siena")
public class ReservaEntity {
    private int idReserva;
    private Timestamp dtAlteracao;
    private boolean inPago;
    private boolean inAtivo;
    private Date dtReserva;

    @Id
    @Column(name = "id_reserva")
    @SequenceGenerator(name = "tb_reserva_id_reserva_seq",
            sequenceName = "admin.tb_reserva_id_reserva_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_reserva_id_reserva_seq")
    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
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
    public boolean isInPago() {
        return inPago;
    }

    public void setInPago(boolean inPago) {
        this.inPago = inPago;
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
