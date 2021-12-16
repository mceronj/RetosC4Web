/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.contracorriente.peripherals.controller;


import com.contracorriente.peripherals.model.Peripheral;
import com.contracorriente.peripherals.service.UserPeripheral;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Monica Ceron Jimenez
 */
@RestController
@RequestMapping("/api/peripherals")
@CrossOrigin("*")
public class PeripheralController {

    @Autowired
    private UserPeripheral userPeripherals;

    @GetMapping("/all")
    public List<Peripheral> getAll() {
        return userPeripherals.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<Peripheral> getPeripherals(@PathVariable("reference") String reference) {
        return userPeripherals.getPeripherals(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Peripheral create(@RequestBody Peripheral peripherals) {
        return userPeripherals.create(peripherals);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Peripheral update(@RequestBody Peripheral peripherals) {
        return userPeripherals.update(peripherals);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return userPeripherals.delete(reference);
    }
    
     @GetMapping("/price/{price}")
    public List<Peripheral> gadgetsByPrice(@PathVariable("price") double precio) {
        return userPeripherals.gadgetsByPrice(precio);
    }

    @GetMapping("/description/{description}")
    public List<Peripheral> findByDescriptionLike(@PathVariable("description") String description) {
        return userPeripherals.findByDescriptionLike(description);
    }

}
