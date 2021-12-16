/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.contracorriente.peripherals.service;

import com.contracorriente.peripherals.model.Peripheral;
import com.contracorriente.peripherals.repository.PeripheralRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Monica ceron Jimenez
 */
@Service
public class UserPeripheral {
     @Autowired
    private PeripheralRepository  peripheralsRepository;
     
     
    public List<Peripheral> getAll() {
        return  peripheralsRepository.getAll();
    }

   public Optional<Peripheral> getPeripherals(String reference) {
        return  peripheralsRepository.getPeripherals(reference);
    }

    public Peripheral create(Peripheral peripherals) {
        if (peripherals.getReference() == null) {
            return peripherals;
        } else {
            return  peripheralsRepository.create(peripherals);
        }
    }

    public Peripheral update(Peripheral peripherals) {

        if (peripherals.getReference() != null) {
            Optional<Peripheral> peripheralsDb =  peripheralsRepository.getPeripherals(peripherals.getReference());
            if (!peripheralsDb.isEmpty()) {
                
                if (peripherals.getBrand()!= null) {
                    peripheralsDb.get().setBrand(peripherals.getBrand());
                }
                
                if (peripherals.getCategory() != null) {
                    peripheralsDb.get().setCategory(peripherals.getCategory());
                }
                                                
                if (peripherals.getDescription() != null) {
                    peripheralsDb.get().setDescription(peripherals.getDescription());
                }
                if (peripherals.getPrice() != 0.0) {
                    peripheralsDb.get().setPrice(peripherals.getPrice());
                }
                if (peripherals.getQuantity() != 0) {
                    peripheralsDb.get().setQuantity(peripherals.getQuantity());
                }
                if (peripherals.getPhotography() != null) {
                    peripheralsDb.get().setPhotography(peripherals.getPhotography());
                }
                peripheralsDb.get().setAvailability(peripherals.isAvailability());
                 peripheralsRepository.update(peripheralsDb.get());
                return peripheralsDb.get();
            } else {
                return peripherals;
            }
        } else {
            return peripherals;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getPeripherals(reference).map(peripherals -> {
             peripheralsRepository.delete(peripherals);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    //Reto 5
    public List<Peripheral> gadgetsByPrice(double price) {
        return  peripheralsRepository.gadgetsByPrice(price);
    }

    //Reto 5
    public List<Peripheral> findByDescriptionLike(String description) {
        return  peripheralsRepository.findByDescriptionLike(description);
    }
    

}
