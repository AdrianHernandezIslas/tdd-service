/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.tddservice.dto;

import edu.mx.tecnm.oaxaca.tddservice.model.TarjetaModel;

/**
 *
 * @author Adrian
 */
public class CargoDTO {
    private TarjetaModel tarjeta;
    private Double monto;

    public TarjetaModel getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(TarjetaModel tarjeta) {
        this.tarjeta = tarjeta;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
    
    
}
