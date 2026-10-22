package com.api.talentolab.model;

import java.util.ArrayList;

public class Pedido {

    // attibutos
    private Long id;
    private ArrayList<Producto> productos;
    protected Cliente cliente;

    // constructor (solo le pasamos el cliente)
    public Pedido(Cliente cliente) {
        this.productos = new ArrayList<>();
        this.cliente = cliente;
    }

    // getters y setters
    public Cliente getCliente() {
        return cliente;
    }

    // método
    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getPrecio() * p.getStock();
        }
        return total;
    }

    // toSting
    @Override
    public String toString() {
        return "Pedido{" +
                "cantidad de productos=" + productos.size() +
                ", Id_cliente=" + cliente.getId() +
                '}';
    }
}

