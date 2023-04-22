package com.app.AylluKuyuy.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Croquis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcroquis;
    private int idFamilia;
    private byte[] mapa;
    private int piso;

    public int getIdcroquis() {
        return idcroquis;
    }

    public void setIdcroquis(int idcroquis) {
        this.idcroquis = idcroquis;
    }

    public int getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(int idFamilia) {
        this.idFamilia = idFamilia;
    }

    public byte[] getMapa() {
        return mapa;
    }

    public void setMapa(byte[] mapa) {
        this.mapa = mapa;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }
}
