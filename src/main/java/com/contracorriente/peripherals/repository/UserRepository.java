/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.contracorriente.peripherals.repository;

import com.contracorriente.peripherals.interfaces.InterfaceUser;
import com.contracorriente.peripherals.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Monica Ceron Jimenez
 */
@Repository
public class UserRepository {

    /**
     * @Autowired atributo de relación Crear implementación de la interface
     */
    @Autowired
    private InterfaceUser interfaceUser;

    /**
     * Método para traer todos los Usuarios
     *
     * @return este nos devolverá el valor dentro del Optional, aunque si este
     * está vacío lanzará una “NoSuchElementException”.
     */
    public List<User> getAll() {
        return (List<User>) interfaceUser.findAll();
    }

    /**
     * Método para encontrar los usuarios por id
     *
     * @param id
     * @return este nos devolverá el valor dentro del Optional, aunque si este
     * está vacío lanzará una “NoSuchElementException”.
     */
    public Optional<User> getUser(int id) {
        return interfaceUser.findById(id);
    }

    /**
     * Método para crear usuario
     *
     * @param user
     * @return el usuario creado o que se guardo
     */
    public User create(User user) {
        return interfaceUser.save(user);
    }

    /**
     * Método para actualizar
     *
     * @param user actualiza la información del usuario
     */
    public void update(User user) {
        interfaceUser.save(user);
    }

    /**
     * Método para eliminar Usuarios
     *
     * @param user elimina el usuario no devuelve nada
     */
    public void delete(User user) {
        interfaceUser.delete(user);
    }

    /**
     * método pra encontrar usuario por el email
     *
     * @param email
     * @return este nos dice si el contenido del Optional es nulo
     */
    public boolean emailExists(String email) {
        Optional<User> usuario = interfaceUser.findByEmail(email);
        return !usuario.isEmpty();
    }

    /**
     * Método par la utenticación del usuario
     *
     * @param email
     * @param password
     * @return los datos encontrados por email y password
     */
    public Optional<User> authenticateUser(String email, String password) {
        return interfaceUser.findByEmailAndPassword(email, password);
    }

    /**
     * Método para la clase user
     *
     * @return
     */
    public Optional<User> lastUserId() {
        return interfaceUser.findTopByOrderByIdDesc();
    }

    /**
     * Método para la clase user
     *
     * @param monthBirthtDay
     * @return lo encontrado por fecha
     */
    public List<User> birthtDayList(String monthBirthtDay) {
        return interfaceUser.findByMonthBirthtDay(monthBirthtDay);
    }

}
