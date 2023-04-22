package com.app.AylluKuyuy.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Integrantes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idintegrante;
    private int idfamilia;
    private String nombre;
    private String apellido;
    private int dni;
    private int telefono;
    private boolean lider;
    private boolean discapacitado;
    private boolean mascota;
    private String roles;

    public int getIdintegrante() {
        return idintegrante;
    }

    public void setIdintegrante(int idintegrante) {
        this.idintegrante = idintegrante;
    }

    public int getIdfamilia() {
        return idfamilia;
    }

    public void setIdfamilia(int idfamilia) {
        this.idfamilia = idfamilia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int DNI) {
        this.dni = DNI;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public boolean isLider() {
        return lider;
    }

    public void setLider(boolean lider) {
        this.lider = lider;
    }

    public boolean isDiscapacitado() {
        return discapacitado;
    }

    public void setDiscapacitado(boolean discapacitado) {
        this.discapacitado = discapacitado;
    }

    public boolean isMascota() {
        return mascota;
    }

    public void setMascota(boolean mascota) {
        this.mascota = mascota;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

}
