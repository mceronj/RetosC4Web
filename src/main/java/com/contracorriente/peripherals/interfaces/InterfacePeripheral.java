/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.contracorriente.peripherals.interfaces;

import com.contracorriente.peripherals.model.Peripheral;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author MOnica Ceron Jimenez
 */
public interface InterfacePeripheral extends MongoRepository<Peripheral, String>{
    public List<Peripheral> findByPriceLessThanEqual(double precio);
    //Reto 5
    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Peripheral> findByDescriptionLike(String description);
}
