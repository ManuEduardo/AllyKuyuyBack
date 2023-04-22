package com.app.AylluKuyuy.modelos;

import java.util.Date;

public class Productos_Mochila {

    private int idMochila;
    private int idProducto;
    private boolean caducable;
    private Date fecha_caducidad;

    public int getIdMochila() {
        return idMochila;
    }

    public void setIdMochila(int idMochila) {
        this.idMochila = idMochila;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public boolean isCaducable() {
        return caducable;
    }

    public void setCaducable(boolean caducable) {
        this.caducable = caducable;
    }

    public Date getFecha_caducidad() {
        return fecha_caducidad;
    }

    public void setFecha_caducidad(Date fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }

    public Productos_Mochila(int idMochila, int idProducto, boolean caducable, Date fecha_caducidad) {
        this.idMochila = idMochila;
        this.idProducto = idProducto;
        this.caducable = caducable;
        this.fecha_caducidad = fecha_caducidad;
    }
}
