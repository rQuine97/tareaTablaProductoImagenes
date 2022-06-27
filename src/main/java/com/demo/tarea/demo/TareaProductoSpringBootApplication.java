package com.demo.tarea.demo;

import com.demo.tarea.demo.entity.Producto;
import com.demo.tarea.demo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TareaProductoSpringBootApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TareaProductoSpringBootApplication.class, args);
    }

    @Autowired
    private ProductoRepository repository;

    @Override
    public void run(String... args) throws Exception {

//        Producto producto1 = new Producto("Monitor", 100, 100, "foto.jpg");
//        repository.save(producto1);
    }

}
