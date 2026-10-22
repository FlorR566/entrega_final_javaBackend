package com.api.talentolab.model;

public class Cliente {

    // atributos
    private Long id;
    private String nombre;
    private String apellido;
    private String email;

    // constructor
    public Cliente() {}

    // sobrecarga constructor
    public Cliente(String nombre, String apellido, String email) {
        setNombre(nombre);
        setApellido(apellido);
        setEmail(email);
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && !email.isBlank() && email.contains("@")) {
            this.email = email;
        }
    }


    // toString
    @Override
    public String toString() {
        return "Cliente[" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                "]";
    }
}
