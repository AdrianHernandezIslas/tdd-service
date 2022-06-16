/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.tddservice.repository;

import edu.mx.tecnm.oaxaca.tddservice.model.TarjetaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Adrian
 */
@Repository
public interface TarjetaRepository extends JpaRepository<TarjetaModel,Integer>{
    public TarjetaModel findByNumero(String numberCard);
}
