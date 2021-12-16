package com.contracorriente.peripherals;


import com.contracorriente.peripherals.interfaces.InterfaceOrder;
import com.contracorriente.peripherals.interfaces.InterfaceUser;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.contracorriente.peripherals.interfaces.InterfacePeripheral;

@SpringBootApplication
public class PeripheralsApplication implements CommandLineRunner {

    @Autowired
    private InterfacePeripheral interfacePeripherals;
    @Autowired
    private InterfaceUser interfaceUser;
    @Autowired
    private InterfaceOrder interfaceOrder;

    public static void main(String[] args) {
        SpringApplication.run(PeripheralsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //para efectos de formateo de fechas
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        interfacePeripherals.deleteAll();
        interfaceUser.deleteAll();
        interfaceOrder.deleteAll();

    }
}
