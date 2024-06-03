/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject4;

/**
 *
 * @author tetra
 */
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "familia")
@NamedQueries({
    @NamedQuery(name = "Familia.findAll", query = "SELECT f FROM Familia f"),
    @NamedQuery(name = "Familia.findByDniAdmin", query = "SELECT f FROM Familia f WHERE f.dniAdmin = :dniAdmin"),
    @NamedQuery(name = "Familia.findById", query = "SELECT f FROM Familia f WHERE f.idFamilia = :idFamilia")
})
public class Familia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_familia")
    private Integer idFamilia;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "dni_admin", nullable = false)
    private String dniAdmin;

    // Constructors
    public Familia() {
    }

    public Familia(String dniAdmin) {
        this.dniAdmin = dniAdmin;
    }

    public Familia(String dniAdmin, String nombre) {
        this.dniAdmin = dniAdmin;
        this.nombre = nombre;
    }

    // Getters and Setters
    public Integer getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(Integer idFamilia) {
        this.idFamilia = idFamilia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDniAdmin() {
        return dniAdmin;
    }

    public void setDniAdmin(String dniAdmin) {
        this.dniAdmin = dniAdmin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dniAdmin != null ? dniAdmin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Familia)) {
            return false;
        }
        Familia other = (Familia) object;
        if ((this.dniAdmin == null && other.dniAdmin != null) || (this.dniAdmin != null && !this.dniAdmin.equals(other.dniAdmin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Familia{"
                + "idFamilia=" + idFamilia
                + ", nombre='" + nombre + '\''
                + ", dniAdmin='" + dniAdmin + '\''
                + '}';
    }
}
