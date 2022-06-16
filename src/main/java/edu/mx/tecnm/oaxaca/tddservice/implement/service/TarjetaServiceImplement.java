/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.tddservice.implement.service;

import edu.mx.tecnm.oaxaca.tddservice.model.TarjetaModel;
import edu.mx.tecnm.oaxaca.tddservice.repository.TarjetaRepository;
import edu.mx.tecnm.oaxaca.tddservice.service.TarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adrian
 */
@Service
public class TarjetaServiceImplement implements TarjetaService{

    @Autowired
    private TarjetaRepository tarjetaRepository;
    
    @Override
    public TarjetaModel createTarjeta(TarjetaModel tarjeta) {
        return tarjetaRepository.save(tarjeta);
    }
    
}
