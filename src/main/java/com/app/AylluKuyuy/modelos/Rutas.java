package com.app.AylluKuyuy.modelos;

public class Rutas {

    private int idruta;
    private int idFamilia;
    private String nombre;
    private String detalle;
    private String tipo;

    public int getIdruta() {
        return idruta;
    }

    public void setIdruta(int idruta) {
        this.idruta = idruta;
    }

    public int getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(int idFamilia) {
        this.idFamilia = idFamilia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Rutas(int idruta, int idFamilia, String nombre, String encuentro, String prioridad) {
        this.idruta = idruta;
        this.idFamilia = idFamilia;
        this.nombre = nombre;
        this.detalle = encuentro;
        this.tipo = prioridad;
    }
}
