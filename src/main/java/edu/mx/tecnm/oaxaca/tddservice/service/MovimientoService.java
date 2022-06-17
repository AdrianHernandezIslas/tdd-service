/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.tddservice.service;

import edu.mx.tecnm.oaxaca.tddservice.model.MovimientoModel;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author Adrian
 */
public interface MovimientoService {
    public MovimientoModel createMovimiento(MovimientoModel movimiento);
    public MovimientoModel updateMovimiento(MovimientoModel movimiento,String folioMovimiento) throws EntityNotFoundException;
    public Optional<MovimientoModel> findByFolioMovimiento(String folioMovimiento) throws EntityNotFoundException;
}
