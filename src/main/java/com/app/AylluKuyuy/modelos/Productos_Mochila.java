package com.app.AylluKuyuy.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Productos_Mochila {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idproducto_mochila;
    private int idMochila;
    private int idProducto;
    private boolean caducable;
    private Date fecha_caducidad;

    public int getIdproducto_mochila() {
        return idproducto_mochila;
    }

    public void setIdproducto_mochila(int idproducto_mochila) {
        this.idproducto_mochila = idproducto_mochila;
    }

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
}
