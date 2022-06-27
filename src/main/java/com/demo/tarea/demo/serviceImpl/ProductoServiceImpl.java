/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.tarea.demo.serviceImpl;

import com.demo.tarea.demo.entity.Producto;
import com.demo.tarea.demo.repository.ProductoRepository;
import com.demo.tarea.demo.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService{
    
    @Autowired
    private ProductoRepository repository;

    @Override
    public List<Producto> readAll() {
        return repository.findAll();
    }

    @Override
    public Producto create(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public Producto update(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public Producto read(int idproducto) {
        return repository.findById(idproducto).get();
    }

    @Override
    public void delete(int idproducto) {
        repository.deleteById(idproducto);
    }
    
}
