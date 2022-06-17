/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.tddservice.exceptions;

import edu.mx.tecnm.oaxaca.tddservice.constans.AuthenticationConstans;

/**
 *
 * @author Adrian
 */
public class UnauthorizedException extends CustomException{
    
    public UnauthorizedException() {
        super(AuthenticationConstans.INVALID_TOKEN_MENSAJE_EXCEPTION);
    }
    
}
