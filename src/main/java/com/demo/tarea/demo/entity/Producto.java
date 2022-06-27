/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.tarea.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idproducto;

    @Column(name = "nombre", nullable = false, length = 40)
    private String nombre;

    @Column(name = "precio", nullable = false)
    private double precio;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "imagen", nullable=false, length=200)
    private String imagen;

    public Producto() {

    }

    public Producto(int idproducto, String nombre, double precio, int cantidad, String imagen) {
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.imagen = imagen;
    }

    public Producto(String nombre, double precio, int cantidad, String imagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.imagen = imagen;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Producto{" + "idproducto=" + idproducto + ", nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad + ", imagen=" + imagen + '}';
    }

}
