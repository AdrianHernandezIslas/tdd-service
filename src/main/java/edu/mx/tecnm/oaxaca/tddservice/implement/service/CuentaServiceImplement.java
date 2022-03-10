/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.tddservice.implement.service;

import edu.mx.tecnm.oaxaca.tddservice.model.CuentaModel;
import edu.mx.tecnm.oaxaca.tddservice.repository.CuentaRepository;
import edu.mx.tecnm.oaxaca.tddservice.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adrian
 */
@Service
public class CuentaServiceImplement implements CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    public void createCuenta(CuentaModel cuenta) {
        cuentaRepository.save(cuenta);
    }

    @Override
    public CuentaModel getCuenta(String numeroCuenta) {
        return cuentaRepository.findByNumeroCuenta(numeroCuenta);
    }

}