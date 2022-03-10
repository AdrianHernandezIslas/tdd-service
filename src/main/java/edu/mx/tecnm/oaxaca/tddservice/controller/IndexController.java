/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.tddservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author shaka
 */
@RestController
public class IndexController {
    
    @GetMapping("/")
    public String index(){
        return "<h1>Sever running</h1>";
    }
}
