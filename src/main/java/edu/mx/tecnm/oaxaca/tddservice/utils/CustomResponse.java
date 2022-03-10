/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.tddservice.utils;

import java.util.LinkedList;

/**
 *
 * @author Adrian
 */
public class CustomResponse {
    private Integer httpCode;
    private Object data;
    private String message;
    
    public CustomResponse(){
        this.httpCode = 200;
        this.data = new LinkedList();
        this.message = "Ok";
    }

    public Integer getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(Integer httpCode) {
        this.httpCode = httpCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
