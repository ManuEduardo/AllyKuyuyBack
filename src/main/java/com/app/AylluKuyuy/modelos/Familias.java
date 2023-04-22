package com.app.AylluKuyuy.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Familias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idfamilia;
    private int cantidad;
    private String direccion;
    private int codigo_familiar;
    private int contrasena;
    private String nombre_familia;


    public int getIdfamilia() {
        return idfamilia;
    }

    public void setIdfamilia(int idfamilia) {
        this.idfamilia = idfamilia;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCodigo_familiar() {
        return codigo_familiar;
    }

    public void setCodigo_familiar(int codigo_familiar) {
        this.codigo_familiar = codigo_familiar;
    }

    public int getContrasena() {
        return contrasena;
    }

    public void setContrasena(int contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre_familia() {
        return nombre_familia;
    }

    public void setNombre_familia(String nombre_familia) {
        this.nombre_familia = nombre_familia;
    }


}
