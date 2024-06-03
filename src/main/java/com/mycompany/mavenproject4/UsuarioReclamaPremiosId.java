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

public class UsuarioReclamaPremiosId implements Serializable {
    private String dni;
    private String idPremio;
    private Date reclamado;

    public UsuarioReclamaPremiosId() {
    }

    public UsuarioReclamaPremiosId(String dni, String idPremio, Date reclamado) {
        this.dni = dni;
        this.idPremio = idPremio;
        this.reclamado = reclamado;
    }

    // Getters and setters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getIdPremio() {
        return idPremio;
    }

    public void setIdPremio(String idPremio) {
        this.idPremio = idPremio;
    }

    public Date getReclamado() {
        return reclamado;
    }

    public void setReclamado(Date reclamado) {
        this.reclamado = reclamado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioReclamaPremiosId)) return false;
        UsuarioReclamaPremiosId that = (UsuarioReclamaPremiosId) o;
        return Objects.equals(getDni(), that.getDni()) &&
               Objects.equals(getIdPremio(), that.getIdPremio()) &&
               Objects.equals(getReclamado(), that.getReclamado());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDni(), getIdPremio(), getReclamado());
    }
}
