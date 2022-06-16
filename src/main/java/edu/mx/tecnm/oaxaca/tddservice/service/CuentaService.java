/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.tddservice.service;

import edu.mx.tecnm.oaxaca.tddservice.model.CuentaModel;
import java.util.List;

/**
 *
 * @author Adrian
 */
public interface CuentaService {
    public CuentaModel createCuenta(CuentaModel cuenta);
    
    public List getCuentas();
    
    public CuentaModel getCuenta(String numeroCuenta);
    
    public void updateCuenta(CuentaModel cuentaModel,Integer idCuenta);
    
    public void deleteCuenta(Integer idCuenta);
}
