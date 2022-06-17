/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.tddservice.controller;

import edu.mx.tecnm.oaxaca.tddservice.authentication.Authentication;
import edu.mx.tecnm.oaxaca.tddservice.model.CuentaModel;
import edu.mx.tecnm.oaxaca.tddservice.model.TarjetaModel;
import edu.mx.tecnm.oaxaca.tddservice.service.CuentaService;
import edu.mx.tecnm.oaxaca.tddservice.service.TarjetaService;
import edu.mx.tecnm.oaxaca.tddservice.utils.CustomResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Adrian
 */
@RestController
@RequestMapping("/api/v1/cuenta")
//@CrossOrigin(origins = "/**")
public class CuentaController {
    
    @Autowired
    private CuentaService cuentaService;
    
    @Autowired
    private TarjetaService tarjetaService;
           
    @PostMapping("/")
    public CustomResponse createCuenta(@RequestBody CuentaModel cuenta) {
        CustomResponse customResponse = new CustomResponse();
        CuentaModel cuentaNueva = cuentaService.createCuenta(cuenta);
        TarjetaModel tarjeta = new TarjetaModel();
        tarjeta.setCuenta(cuentaNueva);
        tarjeta = tarjetaService.createTarjeta(tarjeta);
        customResponse.setData(tarjeta);
        return customResponse;
    }
    
    @GetMapping("/{numeroCuenta}")
    public CustomResponse getClientes(@PathVariable String numeroCuenta,HttpServletRequest request){
        CustomResponse customResponse = new CustomResponse();
        customResponse.setData(cuentaService.getCuentas());
        return customResponse;
    }
    
    @PutMapping("/{idCuenta}")
    public CustomResponse updateCuenta(@RequestBody CuentaModel cuenta,@PathVariable Integer idCuenta){
        CustomResponse customResponse = new CustomResponse();
        cuentaService.updateCuenta(cuenta, idCuenta);
        return customResponse;
    }
    
    @DeleteMapping("/{idCuenta}")
    public CustomResponse deleteCuenta(@PathVariable Integer idCuenta){
        CustomResponse customResponse = new CustomResponse();
        cuentaService.deleteCuenta(idCuenta);
        return customResponse;
    }
}
