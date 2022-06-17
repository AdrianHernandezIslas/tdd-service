/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.tddservice.implement.service;

import edu.mx.tecnm.oaxaca.tddservice.model.TarjetaModel;
import edu.mx.tecnm.oaxaca.tddservice.repository.TarjetaRepository;
import edu.mx.tecnm.oaxaca.tddservice.service.TarjetaService;
import edu.mx.tecnm.oaxaca.tddservice.utils.GeneralFunction;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adrian
 */
@Service
public class TarjetaServiceImplement implements TarjetaService {

    @Autowired
    private TarjetaRepository tarjetaRepository;

    @Autowired
    private GeneralFunction generalFunction;

    @Override
    public TarjetaModel createTarjeta(TarjetaModel tarjeta) {

        tarjeta.setCvv(Integer.parseInt(generalFunction.generateNumberCardClabeAcount(1, 3)));
        tarjeta.setMesVencimiento(12);
        tarjeta.setAnioVencimiento(2022);
        tarjeta.setNumero(generalFunction.generateNumberCardClabeAcount(4, 16));
        return tarjetaRepository.save(tarjeta);
    }

    @Override
    public Optional<TarjetaModel> findByCardNumber(String cardNumber) {
        TarjetaModel tarjeta = tarjetaRepository.findByNumero(cardNumber);
        System.out.println("tarjeta " + tarjeta);
        return Optional.ofNullable(tarjeta);
    }

}
