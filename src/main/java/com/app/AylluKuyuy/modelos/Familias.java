package com.app.AylluKuyuy.modelos;

public class Familias {

    private int idfamilia;
    private int cantidad;
    private String direccion;
    private int cadigo_familiar;
    private int password;
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

    public int getCadigo_familiar() {
        return cadigo_familiar;
    }

    public void setCadigo_familiar(int cadigo_familiar) {
        this.cadigo_familiar = cadigo_familiar;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getNombre_familia() {
        return nombre_familia;
    }

    public void setNombre_familia(String nombre_familia) {
        this.nombre_familia = nombre_familia;
    }

    public Familias(int idfamilia, int cantidad, String direccion, int cadigo_familiar, int password, String nombre_familia) {
        this.idfamilia = idfamilia;
        this.cantidad = cantidad;
        this.direccion = direccion;
        this.cadigo_familiar = cadigo_familiar;
        this.password = password;
        this.nombre_familia = nombre_familia;
    }
}
