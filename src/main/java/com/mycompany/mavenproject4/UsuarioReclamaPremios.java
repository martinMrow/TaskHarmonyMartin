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
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "usuario_reclama_premios")
@IdClass(UsuarioReclamaPremiosId.class) // Clase que define la clave compuesta
public class UsuarioReclamaPremios implements Serializable {

    @Id
    @Column(name = "dni")
    private String dni;

    @Id
    @Column(name = "id_premio")
    private String idPremio;

    @Id
    @Column(name = "reclamado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reclamado;

    @Column(name = "activo")
    private Boolean activo;

    // Getters y setters
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

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @PreUpdate
    @PrePersist
    public void updateActivoStatus() {
        if (this.reclamado != null) {
            // Asigna 'activo' a false si la duraciÃ³n desde 'reclamado' ha excedido un cierto umbral
            // Esta lÃ³gica necesitarÃ¡ ser adaptada segÃºn cÃ³mo se almacene la duraciÃ³n del premio
        }
    }
}
