/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.tarea.demo.controller;

import com.demo.tarea.demo.entity.Producto;
import com.demo.tarea.demo.service.ProductoService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProductoController {

    @Autowired
    private ProductoService service;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/productos")
    public String getProductos(Model modelo) {
        modelo.addAttribute("productos", service.readAll());
        return "productos";
    }

    @GetMapping("/productos/nuevo")
    public String showFormRegisterProducto(Model modelo) {
        Producto producto = new Producto();
        modelo.addAttribute("producto", producto);
        return "crear_producto";
    }

    @PostMapping("/productos")
    public String addProducto(@ModelAttribute("producto") Producto producto, @RequestParam("file") MultipartFile imagen) {

        if (!imagen.isEmpty()) {
            String ruta = "D://Imagenes-Netbeans//files1";

            try {
                byte[] bytesImg = imagen.getBytes();
                Path rutacompleta = Paths.get(ruta + "//" + imagen.getOriginalFilename());
                Files.write(rutacompleta, bytesImg);
                producto.setImagen(imagen.getOriginalFilename());
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }
        }
        service.create(producto);
        return "redirect:/productos";
    }

    @GetMapping("/producto/detalle/{idproducto}")
    public String detalleProducto(@PathVariable("idproducto") int idproducto, Model model) {
        Producto producto = service.read(idproducto);
        model.addAttribute("producto", producto);
        return "detalle_producto";
    }

    @GetMapping("/producto/editar/{idproducto}")
    public String showFormProducto(@PathVariable Integer idproducto, Model model) {
        model.addAttribute("producto", service.read(idproducto));
        return "editar_producto";
    }


    @PostMapping("/producto/{idproducto}")
    public String editProducto(@PathVariable Integer idproducto, @ModelAttribute("producto") Producto producto, @RequestParam("file") MultipartFile imagen) {
        Producto productoExistente = service.read(idproducto);
        if (!imagen.isEmpty()) {
            String ruta = "D://Imagenes-Netbeans//files1";

            try {
                byte[] bytesImg = imagen.getBytes();
                Path rutacompleta = Paths.get(ruta + "//" + imagen.getOriginalFilename());
                Files.write(rutacompleta, bytesImg);
                //Producto productoExistente = service.read(idproducto);
               
                productoExistente.setIdproducto(idproducto);
                productoExistente.setNombre(producto.getNombre());
                productoExistente.setPrecio(producto.getPrecio());
                productoExistente.setCantidad(producto.getCantidad());
                productoExistente.setImagen(imagen.getOriginalFilename());
                
                service.update(productoExistente);
                
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }
        }else {
                productoExistente.setIdproducto(idproducto);
                productoExistente.setNombre(producto.getNombre());
                productoExistente.setPrecio(producto.getPrecio());
                productoExistente.setCantidad(producto.getCantidad());
                service.update(productoExistente);
        }

        return "redirect:/productos";
    }

    @GetMapping("/producto/{idproducto}")
    public String deleteProducto(@PathVariable Integer idproducto) {
        service.delete(idproducto);
        return "redirect:/productos";
    }

}
