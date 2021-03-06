/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.tddservice.controller;

import edu.mx.tecnm.oaxaca.tddservice.authentication.Authentication;
import edu.mx.tecnm.oaxaca.tddservice.dto.CargoDTO;
import edu.mx.tecnm.oaxaca.tddservice.exceptions.CardNotFoudException;
import edu.mx.tecnm.oaxaca.tddservice.exceptions.ExternalMicroserviceException;
import edu.mx.tecnm.oaxaca.tddservice.exceptions.InsufficientFundsException;
import edu.mx.tecnm.oaxaca.tddservice.exceptions.InvalidAmountException;
import edu.mx.tecnm.oaxaca.tddservice.exceptions.UnauthorizedException;
import edu.mx.tecnm.oaxaca.tddservice.model.MovimientoModel;
import edu.mx.tecnm.oaxaca.tddservice.utils.CargoUtil;
import edu.mx.tecnm.oaxaca.tddservice.utils.CustomResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author shaka
 */
@RestController
@RequestMapping("/api/v1/payments")
public class CargoController {

    @Autowired
    private CargoUtil cargoUtil;

    @Autowired
    private Authentication authentication;

    @PostMapping("/")
    public ResponseEntity payment(@RequestBody CargoDTO cargoParam,HttpServletRequest request) {
        ResponseEntity<CustomResponse> valueResponse = null;
        CustomResponse responseData = new CustomResponse();
        try {
            authentication.auth(request);
            MovimientoModel movimiento = cargoUtil.procesarCargoTarjeta(cargoParam);
            responseData.setData(movimiento);
            responseData.setHttpCode(201);
            valueResponse = ResponseEntity.status(HttpStatus.CREATED).body(responseData);
        } catch (CardNotFoudException | InsufficientFundsException | InvalidAmountException ex) {
            responseData.setData(ex.toJSON());
            responseData.setHttpCode(422);
            valueResponse = ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(responseData);
        } catch (UnauthorizedException ex) {
            responseData.setData(ex.toJSON());
            responseData.setHttpCode(401);
            valueResponse = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseData);
        } catch (ExternalMicroserviceException ex) {
             responseData.setData(ex.toJSON());
            responseData.setHttpCode(503);
            valueResponse = ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(responseData);
        } catch (Exception ex) {
            responseData.setHttpCode(500);
            valueResponse = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return valueResponse;
    }

    @PutMapping("/{folioMovimiento}")
    public ResponseEntity cancelPayment(@PathVariable String folioMovimiento,HttpServletRequest request ) {
        ResponseEntity valueResponse = null;
        CustomResponse responseData = new CustomResponse();
        try {
            authentication.auth(request);
            cargoUtil.procesarCancelacionMovimiento(folioMovimiento);
            valueResponse = ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (EntityNotFoundException e) {
            valueResponse = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        catch (UnauthorizedException ex) {
            responseData.setData(ex.toJSON());
            responseData.setHttpCode(401);
            valueResponse = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseData);
        } catch (ExternalMicroserviceException ex) {
             responseData.setData(ex.toJSON());
            responseData.setHttpCode(503);
        }
        catch (Exception ex) {
            valueResponse = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return valueResponse;
    }
}
