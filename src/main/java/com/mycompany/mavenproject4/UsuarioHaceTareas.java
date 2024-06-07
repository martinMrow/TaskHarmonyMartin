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
import java.util.Date;

@Entity
@Table(name = "usuario_hace_tareas")
@IdClass(UsuarioHaceTareasId.class)
public class UsuarioHaceTareas {

    @Id
    @Column(name = "dni")
    private String dni;

    @Id
    @Column(name = "id_tarea")
    private String idTarea;

    @Id
    @Column(name = "fecha_realizada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRealizada;

    @Column(name = "check_tarea")
    private boolean checkTarea;

    @Column(name = "comentarios")
    private String comentarios;

    @Column(name = "puntos_obtenidos")
    private int puntosObtenidos;

    @ManyToOne
    @JoinColumn(name = "id_tarea", referencedColumnName = "id_tarea", insertable = false, updatable = false)
    private Tareas tarea;

    // Getters and setters
    // Asegúrate de incluir getters y setters para la nueva propiedad 'tarea'
    public Tareas getTarea() {
        return tarea;
    }

    public void setTarea(Tareas tarea) {
        this.tarea = tarea;
    }

    // Getters and setters
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

    public boolean isCheckTarea() {
        return checkTarea;
    }

    public void setCheckTarea(boolean checkTarea) {
        this.checkTarea = checkTarea;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public int getPuntosObtenidos() {
        return puntosObtenidos;
    }

    public void setPuntosObtenidos(int puntosObtenidos) {
        this.puntosObtenidos = puntosObtenidos;
    }
}
