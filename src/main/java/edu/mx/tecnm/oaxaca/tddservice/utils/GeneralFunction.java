/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.tddservice.utils;

import org.springframework.stereotype.Component;

/**
 *
 * @author Adrian
 */
@Component
public class GeneralFunction {
    
    public Double createSald(){
        return 100000.0;
    }
    
    public String generateNumberCardClabeAcount(int startNumber,int length){
        String cardNumber = String.valueOf(startNumber);
        for (int i = 0; i < length - 1; i++) {
            int numberRandom = (int) (Math.random() * ((9 - 1) + 1)) + 1;
            cardNumber += String.valueOf(numberRandom);
        }
        return cardNumber;
    }
}
