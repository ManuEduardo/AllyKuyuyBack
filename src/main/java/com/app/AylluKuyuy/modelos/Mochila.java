package com.app.AylluKuyuy.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Mochila {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idmochila;
    private int idfamilia;

    public int getIdfamilia() {
        return idfamilia;
    }

    public void setIdfamilia(int idFamilia) {
        this.idfamilia = idFamilia;
    }

    public int getIdmochila() {
        return idmochila;
    }

    public void setIdmochila(int idMochila) {
        this.idmochila = idMochila;
    }

}
