/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.tddservice.service;

import edu.mx.tecnm.oaxaca.tddservice.model.TarjetaModel;
import java.util.Optional;

/**
 *
 * @author Adrian
 */
public interface TarjetaService {
    public TarjetaModel createTarjeta(TarjetaModel tarjeta);
    
    public Optional<TarjetaModel> findByCardNumber(String cardNumber);
}
