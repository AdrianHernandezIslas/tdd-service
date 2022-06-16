/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.tddservice.controller;

import edu.mx.tecnm.oaxaca.tddservice.model.TarjetaModel;
import edu.mx.tecnm.oaxaca.tddservice.service.TarjetaService;
import edu.mx.tecnm.oaxaca.tddservice.utils.CustomResponse;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author shaka
 */
@RestController
@RequestMapping("/api/v1/payments")
public class PagoController {
    @Autowired
    private TarjetaService tarjetaService;
    
    @PostMapping("/")
    public ResponseEntity<CustomResponse> payment(@RequestBody TarjetaModel tarjetaParam,HttpServletResponse response){
        String numberCard = tarjetaParam.getNumero();
        Optional<TarjetaModel> tarjetaLocal = tarjetaService.findByCardNumber(numberCard);
        
        return  ResponseEntity.status(201).body(new CustomResponse());
    }
}
