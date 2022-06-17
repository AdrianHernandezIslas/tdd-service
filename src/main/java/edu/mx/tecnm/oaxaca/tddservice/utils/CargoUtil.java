/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.tddservice.utils;

import edu.mx.tecnm.oaxaca.tddservice.dto.CargoDTO;
import edu.mx.tecnm.oaxaca.tddservice.enums.EstatusMovimientoEnum;
import edu.mx.tecnm.oaxaca.tddservice.enums.TipoMovimientoEnum;
import edu.mx.tecnm.oaxaca.tddservice.exceptions.CardNotFoudException;
import edu.mx.tecnm.oaxaca.tddservice.exceptions.InsufficientFundsException;
import edu.mx.tecnm.oaxaca.tddservice.exceptions.InvalidAmountException;
import edu.mx.tecnm.oaxaca.tddservice.model.CuentaModel;
import edu.mx.tecnm.oaxaca.tddservice.model.MovimientoModel;
import edu.mx.tecnm.oaxaca.tddservice.model.TarjetaModel;
import edu.mx.tecnm.oaxaca.tddservice.service.CuentaService;
import edu.mx.tecnm.oaxaca.tddservice.service.MovimientoService;
import edu.mx.tecnm.oaxaca.tddservice.service.TarjetaService;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Adrian
 */
@Component
public class CargoUtil {

    @Autowired
    private TarjetaService tarjetaService;

    @Autowired
    private CuentaService cuentaService;

    @Autowired
    private MovimientoService movimientoService;

    private final Double AMOUNT_MIN = 1.0;

    public MovimientoModel procesarCargoTarjeta(CargoDTO cargo) throws CardNotFoudException, InvalidAmountException, InsufficientFundsException {
        String numberCard = cargo.getTarjeta().getNumero();
        Optional<TarjetaModel> tarjetaOptional = tarjetaService.findByCardNumber(numberCard);
        validations(tarjetaOptional, cargo);

        TarjetaModel tarjeta = tarjetaOptional.get();
        CuentaModel cuenta = tarjeta.getCuenta();
        Double saldoCuenta = cuenta.getSaldo();
        Double nuevoSaldoCuenta = saldoCuenta - cargo.getMonto();
        cuenta.setSaldo(nuevoSaldoCuenta);

        cuentaService.updateCuenta(cuenta, cuenta.getIdCuenta());
        return createMovimiento(cargo.getMonto(), cuenta,TipoMovimientoEnum.CARGO);

    }

    public void procesarCancelacionMovimiento(String folioMovimiento) {
        Optional<MovimientoModel> movimientoOptional = movimientoService.findByFolioMovimiento(folioMovimiento);
        if (!movimientoOptional.isPresent()) {
            throw new EntityNotFoundException();
        }
        MovimientoModel movimiento = movimientoOptional.get();
        movimiento.setEstatusMovimiento(EstatusMovimientoEnum.CANCELADO);
        movimientoService.updateMovimiento(movimiento, folioMovimiento);
        CuentaModel cuenta = movimiento.getCuenta();
        Double saldoCuenta = cuenta.getSaldo();
        Double nuevoSaldoCuenta = saldoCuenta + movimiento.getMonto();
        cuenta.setSaldo(nuevoSaldoCuenta);

        cuentaService.updateCuenta(cuenta, cuenta.getIdCuenta());
        createMovimiento(movimiento.getMonto(), cuenta,TipoMovimientoEnum.ABONO);
    }

    private void validations(Optional<TarjetaModel> tarjetaOptional, CargoDTO cargo) throws CardNotFoudException, InvalidAmountException, InsufficientFundsException {
        if (!tarjetaOptional.isPresent()) {
            throw new CardNotFoudException();
        }

        TarjetaModel tarjeta = tarjetaOptional.get();
        TarjetaModel tarjetaParam = cargo.getTarjeta();
        Double saldoCuentaTarjeta = tarjeta.getCuenta().getSaldo();

        if (!tarjeta.equals(tarjetaParam)) {
            throw new CardNotFoudException();
        }

        if (cargo.getMonto() < AMOUNT_MIN) {
            throw new InvalidAmountException();
        }

        if (cargo.getMonto() > saldoCuentaTarjeta) {
            throw new InsufficientFundsException();
        }

    }

    private MovimientoModel createMovimiento(Double monto, CuentaModel cuenta,TipoMovimientoEnum tipo) {
        MovimientoModel movimiento = new MovimientoModel();
        movimiento.setMonto(monto);
        movimiento.setEstatusMovimiento(EstatusMovimientoEnum.APLICADO);
        movimiento.setTipoMovimiento(tipo);
        movimiento.setCuenta(cuenta);
        return movimientoService.createMovimiento(movimiento);
    }
}
