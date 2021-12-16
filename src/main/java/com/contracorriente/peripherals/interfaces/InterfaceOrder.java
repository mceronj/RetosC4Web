/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.contracorriente.peripherals.interfaces;

import com.contracorriente.peripherals.model.Order;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author Monica Ceron Jimenez
 */
public interface InterfaceOrder extends MongoRepository<Order, Integer> {
    //List<Order> findBySalesManZone(String zone);
    
    //Retorna las ordenes de pedido que coincidad con la zona recibida como parametro
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String zone);
    
    //Retorna las ordenes x estado
    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);
    
    //Para seleccionar la orden con el id maximo
    Optional<Order> findTopByOrderByIdDesc();
    
//    List<Order> findBySalesManId(Integer id);
//    List<Order> findBySalesManIdAndStatus(Integer id, String status);
//    List<Order> findByRegisterDayAndSalesManId(Date registerDay, Integer id);
}