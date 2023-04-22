package com.app.AylluKuyuy.modelos;

public class Mochila {

    private int idFamilia;
    private int idMochila;

    public int getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(int idFamilia) {
        this.idFamilia = idFamilia;
    }

    public int getIdMochila() {
        return idMochila;
    }

    public void setIdMochila(int idMochila) {
        this.idMochila = idMochila;
    }

    public Mochila(int idFamilia, int idMochila) {
        this.idFamilia = idFamilia;
        this.idMochila = idMochila;
    }

}
