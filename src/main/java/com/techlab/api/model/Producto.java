package com.techlab.api.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Producto {

    // atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private BigDecimal precio;
    private int stock;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;


    // constructor vacío que usa JPA para crear los objetos al leer la base
    public  Producto() {
    }

    // sobrecarga de constructor
    public Producto(String nombre, BigDecimal precio, int stock, Categoria categoria) {
        setNombre(nombre);
        setPrecio(precio);
        setStock(stock);
        setCategoria(categoria);
    }

    // getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
            this.categoria = categoria;
    }

    // método
    public void mostrar() {
        System.out.println("ID: " + id +
                " | " + nombre +
                " | $" + precio +
                " | Stock: " + stock +
                " | Categoría: " + categoria);
    }


    // toString
    @Override
    public String toString() {
        return "ID: " + id +
                " | " + nombre +
                " | $" + precio +
                " | Stock: " + stock +
                " | Categoría: " + categoria;
    }


}
