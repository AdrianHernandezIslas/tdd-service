/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.tddservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name = "cuenta")
public class CuentaModel implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Integer idCuenta;
    private String clabe;
    private String numeroCuenta;
    private String nombreTitular;
    private String primerApellidoTitular;
    private String segundoApellidoTitular;
    private Double saldo;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaCreacion;

    @JsonIgnore
    @OneToMany(mappedBy = "cuenta")
    private Set<TarjetaModel> tarjetas;
    
    @JsonIgnore
    @OneToMany(mappedBy = "cuenta")
    private Set<MovimientoModel> movimientos;

    public Set<TarjetaModel> getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(Set<TarjetaModel> tarjetas) {
        this.tarjetas = tarjetas;
    }

    public Set<MovimientoModel> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(Set<MovimientoModel> movimientos) {
        this.movimientos = movimientos;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getClabe() {
        return clabe;
    }

    public void setClabe(String clabe) {
        this.clabe = clabe;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getPrimerApellidoTitular() {
        return primerApellidoTitular;
    }

    public void setPrimerApellidoTitular(String primerApellidoTitular) {
        this.primerApellidoTitular = primerApellidoTitular;
    }

    public String getSegundoApellidoTitular() {
        return segundoApellidoTitular;
    }

    public void setSegundoApellidoTitular(String segundoApellidoTitular) {
        this.segundoApellidoTitular = segundoApellidoTitular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

}
