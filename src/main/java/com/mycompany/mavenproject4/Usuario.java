/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject4;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT e FROM Usuario e"),
    @NamedQuery(name = "Usuario.findByDni", query = "SELECT e FROM Usuario e WHERE e.dni = :dni"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT e FROM Usuario e WHERE e.nombre = :nombre")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "dni", nullable = false, length = 9)
    private String dni;

    @Column(name = "nombre", length = 25)
    private String nombre;

    @Column(name = "apellidos", length = 50)
    private String apellidos;

    @Column(name = "pass", length = 50)
    private String pass;

    public Usuario() {
    }

    public Usuario(String dni, String nombre, String apellidos, String pass) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.pass = pass;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Usuario{" +
               "dni='" + dni + '\'' +
               ", nombre='" + nombre + '\'' +
               ", apellidos='" + apellidos + '\'' +
               ", pass='" + pass + '\'' +
               '}';
    }
}
