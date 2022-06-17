/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.tddservice.utils;

import edu.mx.tecnm.oaxaca.tddservice.dto.CargoDTO;
import edu.mx.tecnm.oaxaca.tddservice.exceptions.CardNotFoudException;
import edu.mx.tecnm.oaxaca.tddservice.exceptions.InsufficientFundsException;
import edu.mx.tecnm.oaxaca.tddservice.exceptions.InvalidAmountException;
import edu.mx.tecnm.oaxaca.tddservice.model.TarjetaModel;


/**
 *
 * @author Adrian
 */
public class Pruebas {
    public static void main(String[] args) {
        CargoUtil cargoUtil = new CargoUtil();
        
        TarjetaModel tarjeta = new TarjetaModel();
        tarjeta.setNumero("");
        
        CargoDTO cargo = new CargoDTO();
        try {
            cargoUtil.procesarCargoTarjeta(cargo);
        } catch (CardNotFoudException | InvalidAmountException | InsufficientFundsException ex) {
            
        }
        
    }
}
