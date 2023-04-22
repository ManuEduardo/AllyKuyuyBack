package com.app.AylluKuyuy.modelos;

public class Productos {

    private int idproducto;
    private String nombre;

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

    public Productos(int idproducto, String nombre) {
        this.idproducto = idproducto;
        this.nombre = nombre;
    }
}
