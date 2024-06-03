/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject4;

/**
 *
 * @author tetra
 */
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ServicioAplicacion {

    private EntityManagerFactory emf;
    private UsuarioJpaController usuarioController;
    private UsuarioPerteneceFamiliaJpaController usuarioPerteneceFamiliaController;
    private FamiliaJpaController famCont;
    private TareasJpaController tareasCont;
    private UsuarioHaceTareasJpaController uhtCont;
    private PremiosJpaController premCont;
    private UsuarioReclamaPremiosJpaController urpCont;
    
    public ServicioAplicacion() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unidadJPA");
        usuarioController = new UsuarioJpaController(emf);
        famCont = new FamiliaJpaController(emf);
        usuarioPerteneceFamiliaController = new UsuarioPerteneceFamiliaJpaController(emf);
        tareasCont = new TareasJpaController(emf);
        uhtCont = new UsuarioHaceTareasJpaController(emf);
        premCont=new PremiosJpaController(emf);
        urpCont = new UsuarioReclamaPremiosJpaController(emf);
    }

    public void crearUsuarioHaceTarea(UsuarioHaceTareas usuarioHaceTarea) {
        try {
            uhtCont.create(usuarioHaceTarea);
            System.out.println("Registro de tarea completada con éxito.");
        } catch (Exception e) {
            System.err.println("Error al registrar la tarea como completada: " + e.getMessage());
        }
    }

    public List<Tareas> obtenerTareasActivasPorFamilia(int idFamilia) {
        return tareasCont.findActiveTareasByFamilia(idFamilia);
    }

    public List<Premios> obtenerPremiosActivosPorFamilia(int idFamilia) {
        return premCont.findActivePremiosByFamilia(idFamilia);
    }

    // Métodos para usuario
    public void registrarUsuario(String dni, String nombre, String apellidos, String password) {
        Usuario usuario = new Usuario(dni, nombre, apellidos, password);
        try {
            usuarioController.create(usuario);
            System.out.println("Usuario registrado exitosamente");
        } catch (Exception e) {
            System.out.println("Error al registrar el usuario: " + e.getMessage());
        }
    }

    public boolean autenticarUsuario(String dni, String password) {
        Usuario usuario = usuarioController.findUsuario(dni);
        if (usuario != null && usuario.getPass().equals(password)) {
            return true;
        }
        return false;
    }

    public List<UsuarioPerteneceFamilia> obtenerFamiliasPorUsuario(String dni) {
        return usuarioPerteneceFamiliaController.findFamiliasByUsuario(dni);
    }

    public List<UsuarioPerteneceFamilia> obtenerFamiliasActivasPorUsuario(String dni) {
        return usuarioPerteneceFamiliaController.findActiveFamiliasByUsuario(dni);
    }

    public void cerrar() {
        emf.close();
    }

    public void createFamilia(Familia nuevaFamilia) {
        this.famCont.create(nuevaFamilia);
    }

    public Familia findFamiliaByDniAdmin(String dniUsuario) {
        Familia famComodin = this.famCont.findFamiliaByDniAdmin(dniUsuario);
        return famComodin;
    }

    

    public void crearUsuarioReclamaPremio(UsuarioReclamaPremios premioReclamado) {
        urpCont.create(premioReclamado);
    }

    public void editarTarea(Tareas tareaSeleccionada) throws Exception {
        tareasCont.edit(tareaSeleccionada);
    }
    public void CrearTarea(Tareas tareaSeleccionada) throws Exception {
        tareasCont.create(tareaSeleccionada);
    }

    public Tareas findTareaById(String nuevaIdTarea) {
        return tareasCont.findTareas(nuevaIdTarea);
    }

}
