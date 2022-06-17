/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.tddservice.exceptions;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Adrian
 */
public abstract class CustomException extends Exception {

    public CustomException(String string) {
        super(string);
    }

    public Map<String, Object> toJSON() {
        Map<String, Object> exception = new HashMap();
        exception.put("errorName", getClass().getSimpleName());
        exception.put("cause", getMessage());
        return exception;
    }
}
