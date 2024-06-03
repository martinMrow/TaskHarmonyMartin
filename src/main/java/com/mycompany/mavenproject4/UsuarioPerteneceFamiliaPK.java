/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject4;

/**
 *
 * @author tetra
 */
import java.io.Serializable;
import javax.persistence.*;

public class UsuarioPerteneceFamiliaPK implements Serializable {
    private String dni;
    private int idFamilia;

    // Constructors, getters, setters, hashCode, equals
    public UsuarioPerteneceFamiliaPK() {
    }

    public UsuarioPerteneceFamiliaPK(String dni, int idFamilia) {
        this.dni = dni;
        this.idFamilia = idFamilia;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(int idFamilia) {
        this.idFamilia = idFamilia;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        UsuarioPerteneceFamiliaPK that = (UsuarioPerteneceFamiliaPK) object;

        if (idFamilia != that.idFamilia) return false;
        return dni != null ? dni.equals(that.dni) : that.dni == null;
    }

    @Override
    public int hashCode() {
        int result = dni != null ? dni.hashCode() : 0;
        result = 31 * result + idFamilia;
        return result;
    }
}
