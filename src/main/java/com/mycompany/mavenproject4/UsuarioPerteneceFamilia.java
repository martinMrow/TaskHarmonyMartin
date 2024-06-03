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

@Entity
@Table(name = "usuario_pertenece_familia")
@IdClass(UsuarioPerteneceFamiliaPK.class)
public class UsuarioPerteneceFamilia {

    @Id
    @Column(name = "dni", length = 9)
    private String dni;

    @Id
    @Column(name = "id_familia")
    private int idFamilia;

    @Column(name = "puntos")
    private Integer puntos;

    @Column(name = "isActive")
    private Boolean isActive = false;

    public UsuarioPerteneceFamilia() {
    }

    // Getters and setters
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

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
