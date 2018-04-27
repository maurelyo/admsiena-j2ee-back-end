package com.br.siena.domain;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tb_reserva", schema = "admin", catalog = "siena")
public class ReservaEntity {

    @Id
    @Column(name = "id_reserva", nullable = false)
    @SequenceGenerator(name = "tb_reserva_id_reserva_seq",
            sequenceName = "admin.tb_reserva_id_reserva_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_reserva_id_reserva_seq")
    private int idReserva;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "id_espaco", nullable = false)
    private EspacoEntity espaco;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "id_usuario", nullable = false)
    private UsuarioEntity usuario;

    @Basic
    @Column(name = "dt_alteracao", nullable = false)
    private Timestamp dtAlteracao;

    @Basic
    @Column(name = "in_pago", nullable = false)
    private boolean inPago;

    @Basic
    @Column(name = "in_ativo", nullable = false)
    private boolean inAtivo;

    @Basic
    @Column(name = "dt_reserva", nullable = false)
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

    public EspacoEntity getEspaco() {
        return espaco;
    }

    public void setEspaco(EspacoEntity espaco) {
        this.espaco = espaco;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReservaEntity)) return false;
        ReservaEntity that = (ReservaEntity) o;
        return getIdReserva() == that.getIdReserva() &&
                isInPago() == that.isInPago() &&
                isInAtivo() == that.isInAtivo() &&
                Objects.equals(getEspaco(), that.getEspaco()) &&
                Objects.equals(getUsuario(), that.getUsuario()) &&
                Objects.equals(getDtAlteracao(), that.getDtAlteracao()) &&
                Objects.equals(getDtReserva(), that.getDtReserva());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdReserva(), getEspaco(), getUsuario(), getDtAlteracao(), isInPago(), isInAtivo(), getDtReserva());
    }
}
