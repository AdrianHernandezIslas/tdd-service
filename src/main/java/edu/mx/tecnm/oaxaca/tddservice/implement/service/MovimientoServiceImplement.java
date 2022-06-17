/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.tddservice.implement.service;

import edu.mx.tecnm.oaxaca.tddservice.model.MovimientoModel;
import edu.mx.tecnm.oaxaca.tddservice.repository.MovimientoRepository;
import edu.mx.tecnm.oaxaca.tddservice.service.MovimientoService;
import java.util.Date;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adrian
 */
@Service
public class MovimientoServiceImplement implements MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Override
    public MovimientoModel createMovimiento(MovimientoModel movimiento) {
        movimiento.setFechaCreacion(new Date());
        return movimientoRepository.save(movimiento);
    }

    @Override
    public MovimientoModel updateMovimiento(MovimientoModel movimiento,String folioMovimiento) throws EntityNotFoundException{
        movimiento.setFolioMovimiento(folioMovimiento);
        return movimientoRepository.save(movimiento);
    }

    @Override
    public Optional<MovimientoModel> findByFolioMovimiento(String folioMovimiento) throws EntityNotFoundException {
       return movimientoRepository.findById(folioMovimiento);
    }

}
