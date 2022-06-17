/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.tddservice.exceptions;

import edu.mx.tecnm.oaxaca.tddservice.constans.PagoConstans;

/**
 *
 * @author Adrian
 */
public class CardNotFoudException extends CustomException{
    public CardNotFoudException() {
        super(PagoConstans.TARJETA_MENSAJE_EXCEPTION);
    } 
}
