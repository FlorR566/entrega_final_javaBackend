package com.api.talentolab.model;

public class Producto {

    // atributos
    private Long id;
    private String nombre;
    private double precio;
    private int stock;
    private String categoria;

    // constructor vacío
    public  Producto() {
    }

    // sobrecarga de constructor
    public Producto(String nombre, double precio, int stock, String categoria) {
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        if (categoria != null && !categoria.isBlank()) {
            this.categoria = categoria;
        }
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
