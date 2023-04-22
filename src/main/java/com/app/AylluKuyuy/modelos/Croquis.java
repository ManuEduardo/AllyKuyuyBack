package com.app.AylluKuyuy.modelos;

public class Croquis {

    private int idcroquis;
    private int idFamilia;
    private long mapa;
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

    public long getMapa() {
        return mapa;
    }

    public void setMapa(long mapa) {
        this.mapa = mapa;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public Croquis(int idcroquis, int idFamilia, long mapa, int piso) {
        this.idcroquis = idcroquis;
        this.idFamilia = idFamilia;
        this.mapa = mapa;
        this.piso = piso;
    }
}
