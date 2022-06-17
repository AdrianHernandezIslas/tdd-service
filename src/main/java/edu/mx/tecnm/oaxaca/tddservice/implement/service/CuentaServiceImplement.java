/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.tddservice.implement.service;

import edu.mx.tecnm.oaxaca.tddservice.model.CuentaModel;
import edu.mx.tecnm.oaxaca.tddservice.repository.CuentaRepository;
import edu.mx.tecnm.oaxaca.tddservice.service.CuentaService;
import edu.mx.tecnm.oaxaca.tddservice.utils.GeneralFunction;
import java.util.Date;
import java.util.List;
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
    
    @Autowired
    private GeneralFunction generalFunction;

    @Override
    public CuentaModel createCuenta(CuentaModel cuenta) {
        cuenta.setFechaCreacion(new Date());
        cuenta.setSaldo(generalFunction.createSald());
        cuenta.setNumeroCuenta(generalFunction.generateNumberCardClabeAcount(8, 10));
        cuenta.setClabe(generalFunction.generateNumberCardClabeAcount(1, 18));
        return cuentaRepository.save(cuenta);
    }

    @Override
    public CuentaModel getCuenta(String numeroCuenta) {
        return cuentaRepository.findByNumeroCuenta(numeroCuenta);
    }

    @Override
    public void updateCuenta(CuentaModel cuentaModel, Integer idCuenta) {
        cuentaModel.setIdCuenta(idCuenta);
        cuentaRepository.save(cuentaModel);
    }

    @Override
    public void deleteCuenta(Integer idCuenta) {
       cuentaRepository.deleteById(idCuenta);
    }

    @Override
    public List getCuentas() {
        return cuentaRepository.findAll();
    }
}
