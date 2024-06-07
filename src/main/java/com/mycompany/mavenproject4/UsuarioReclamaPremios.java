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
public class UsuarioReclamaPremios implements Serializable {

    @Id
    @Column(name = "dni")
    private String dni;

    @Id
    @Column(name = "id_premio")
    private String idPremio;

    @ManyToOne
    @JoinColumn(name = "id_premio", referencedColumnName = "id_premio", insertable = false, updatable = false)
    private Premios premio;

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
        if (this.reclamado != null && this.premio != null) {
            Date today = new Date();
            long durationInMillis = this.premio.getDuracion() * 24 * 60 * 60 * 1000; 
            Date expirationDate = new Date(this.reclamado.getTime() + durationInMillis);

            if (today.after(expirationDate)) {
                this.activo = false; 
            }
        }
    }
}
