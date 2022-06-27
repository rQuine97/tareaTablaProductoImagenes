/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.demo.tarea.demo.service;

import com.demo.tarea.demo.entity.Producto;
import java.util.List;


public interface ProductoService {
    public List<Producto> readAll();
    public Producto create(Producto producto);
    public Producto update(Producto producto);
    public Producto read(int idproducto);
    public void delete(int idproducto);
}
