/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.tddservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import edu.mx.tecnm.oaxaca.tddservice.enums.EstatusMovimientoEnum;
import edu.mx.tecnm.oaxaca.tddservice.enums.TipoMovimientoEnum;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name = "movimiento")
public class MovimientoModel implements Serializable {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(length = 36, nullable = false, updatable = false)
    private String folioMovimiento;

    @Column(nullable = false, updatable = false)
    private Double monto;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaCreacion;

    @Column(columnDefinition = "varchar(5)")
    @Enumerated(EnumType.STRING)
    private TipoMovimientoEnum tipoMovimiento;

    @Column(columnDefinition = "varchar(10)")
    @Enumerated(EnumType.STRING)
    private EstatusMovimientoEnum estatusMovimiento;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cuenta", nullable = false)
    private CuentaModel cuenta;

    public String getFolioMovimiento() {
        return folioMovimiento;
    }

    public void setFolioMovimiento(String folioMovimiento) {
        this.folioMovimiento = folioMovimiento;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public TipoMovimientoEnum getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(TipoMovimientoEnum tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public CuentaModel getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaModel cuenta) {
        this.cuenta = cuenta;
    }

    public EstatusMovimientoEnum getEstatusMovimiento() {
        return estatusMovimiento;
    }

    public void setEstatusMovimiento(EstatusMovimientoEnum estatusMovimiento) {
        this.estatusMovimiento = estatusMovimiento;
    }
}
