/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.contracorriente.peripherals.repository;

import com.contracorriente.peripherals.model.Peripheral;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.contracorriente.peripherals.interfaces.InterfacePeripheral;

/**
 *
 * @author Monica Ceron Jimenez
 */
@Repository
public class PeripheralRepository {
    @Autowired
    private InterfacePeripheral interfacePeripherals;

    public List<Peripheral> getAll() {
        return interfacePeripherals.findAll();
    }

    public Optional<Peripheral> getPeripherals(String reference) {
        return interfacePeripherals.findById(reference);
    }
    public Peripheral create(Peripheral peripherals) {
        return interfacePeripherals.save(peripherals);
    }

    public void update(Peripheral peripherals) {
        interfacePeripherals.save(peripherals);
    }
    
    public void delete(Peripheral peripherals) {
        interfacePeripherals.delete(peripherals);
    }
    //Reto 5
    public List<Peripheral> gadgetsByPrice(double precio) {
        return interfacePeripherals.findByPriceLessThanEqual(precio);
    }
    //Reto 5
    public List<Peripheral> findByDescriptionLike(String description) {
        return interfacePeripherals.findByDescriptionLike(description);
    }


}
