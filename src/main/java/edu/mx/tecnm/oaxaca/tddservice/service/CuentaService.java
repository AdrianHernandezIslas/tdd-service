/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.tddservice.service;

import edu.mx.tecnm.oaxaca.tddservice.model.CuentaModel;

/**
 *
 * @author Adrian
 */
public interface CuentaService {
    public void createCuenta(CuentaModel cuenta);
    
    public CuentaModel getCuenta(String numeroCuenta);
}
