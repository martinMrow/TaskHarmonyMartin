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
import java.util.Date;
import java.util.Objects;

public class UsuarioHaceTareasId implements Serializable {
    private String dni;
    private String idTarea;
    private Date fechaRealizada;

    public UsuarioHaceTareasId() {
    }

    public UsuarioHaceTareasId(String dni, String idTarea, Date fechaRealizada) {
        this.dni = dni;
        this.idTarea = idTarea;
        this.fechaRealizada = fechaRealizada;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(String idTarea) {
        this.idTarea = idTarea;
    }

    public Date getFechaRealizada() {
        return fechaRealizada;
    }

    public void setFechaRealizada(Date fechaRealizada) {
        this.fechaRealizada = fechaRealizada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioHaceTareasId that = (UsuarioHaceTareasId) o;
        return Objects.equals(dni, that.dni) &&
               Objects.equals(idTarea, that.idTarea) &&
               Objects.equals(fechaRealizada, that.fechaRealizada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, idTarea, fechaRealizada);
    }
}
