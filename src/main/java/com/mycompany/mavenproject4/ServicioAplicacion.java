/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject4;

/**
 *
 * @author tetra
 */
import com.mycompany.mavenproject4.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class ServicioAplicacion {

    private EntityManagerFactory emf;
    private UsuarioJpaController usuarioController;
    private UsuarioPerteneceFamiliaJpaController usuarioPerteneceFamiliaController;
    private FamiliaJpaController famCont;
    private TareasJpaController tareasCont;
    private UsuarioHaceTareasJpaController uhtCont;
    private PremiosJpaController premCont;
    private NotificacionesJpaController notCont;
    private UsuarioReclamaPremiosJpaController urpCont;

    public ServicioAplicacion() {
        this.emf = Persistence.createEntityManagerFactory("unidadJPA");
        this.usuarioController = new UsuarioJpaController(emf);
        famCont = new FamiliaJpaController(emf);
        usuarioPerteneceFamiliaController = new UsuarioPerteneceFamiliaJpaController(emf);
        tareasCont = new TareasJpaController(emf);
        uhtCont = new UsuarioHaceTareasJpaController(emf);
        premCont = new PremiosJpaController(emf);
        urpCont = new UsuarioReclamaPremiosJpaController(emf);
        notCont = new NotificacionesJpaController(emf);
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
    public boolean registrarUsuario(String dni, String nombre, String apellidos, String password) {
        Usuario usuario = new Usuario(dni, nombre, apellidos, password);
        try {
            usuarioController.create(usuario);
            System.out.println("Usuario registrado exitosamente");
            return true;  // Retornar true si el registro es exitoso
        } catch (Exception e) {
            System.out.println("Error al registrar el usuario: " + e.getMessage());
            return false;  // Retornar false si ocurre un error
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

    public Premios findPremioById(String idPremio) {
        return premCont.findPremio(idPremio);
    }

    public void createPremio(Premios nuevoPremio) {
        premCont.create(nuevoPremio);
    }

    public List<UsuarioHaceTareas> obtenerTareasRealizadasPorUsuarioEnFamilia(String dni, int idFamilia) {
        return uhtCont.findTareasHechasPorUsuarioEnFamilia(dni, idFamilia);
    }

    public List<UsuarioHaceTareas> obtenerTareasRealizadasPorFamilia(int idFamilia) {
        return uhtCont.findTareasHechasPorFamilia(idFamilia);
    }

    public List<UsuarioReclamaPremios> findPremiosActivosPorUsuarioEnFamilia(String dni, int idFamilia) {
        return urpCont.findPremiosActivosPorUsuarioEnFamilia(dni, idFamilia);
    }

    public List<UsuarioReclamaPremios> findPremiosActivosPorFamilia(int idFamilia) {
        return urpCont.findPremiosActivosPorFamilia(idFamilia);
    }

    public void editUsuarioPerteneceFamilia(UsuarioPerteneceFamilia upf) throws Exception {
        usuarioPerteneceFamiliaController.edit(upf);
    }

    public UsuarioPerteneceFamilia findUsuarioPerteneceFamilia(UsuarioPerteneceFamiliaPK usuarioPerteneceFamiliaPK) {
        return usuarioPerteneceFamiliaController.findUsuarioPerteneceFamilia(usuarioPerteneceFamiliaPK);
    }

    public Usuario findUsuarioByDni(String id) {
        return usuarioController.findUsuario(id);
    }

    public void editarPremio(Premios premioSeleccionado) throws Exception {
        premCont.edit(premioSeleccionado);
    }

    public List<Notificaciones> obtenerNotificacionesPorAdmin(String dni) {
        return notCont.findNotificacionesByAdmin(dni);
    }

    public Notificaciones findNotificacion(Long idNotificacion) {
        return notCont.findNotificacion(idNotificacion);
    }

    public void aceptarSolicitud(String dni, int idFamilia) throws Exception {
        UsuarioPerteneceFamiliaPK idUPF = new UsuarioPerteneceFamiliaPK(dni, idFamilia);
        UsuarioPerteneceFamilia usuarioSolicitante = usuarioPerteneceFamiliaController.findUsuarioPerteneceFamilia(idUPF);
        usuarioSolicitante.setIsActive(Boolean.TRUE);
        usuarioPerteneceFamiliaController.edit(usuarioSolicitante);
    }

    public void denegarSolicitud(String dni, int idFamilia) {
        try {
            UsuarioPerteneceFamiliaPK idUPF = new UsuarioPerteneceFamiliaPK(dni, idFamilia);
            UsuarioPerteneceFamilia usuarioSolicitante = usuarioPerteneceFamiliaController.findUsuarioPerteneceFamilia(idUPF);
            usuarioPerteneceFamiliaController.destroy(idUPF);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ServicioAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void procesarSolicitudUnirseAFamilia(String dniAdmin, Usuario user) {
        Familia familia = famCont.findFamiliaByDniAdmin(dniAdmin);
        if (familia != null) {
            UsuarioPerteneceFamilia upf = new UsuarioPerteneceFamilia();
            upf.setIsActive(false);  // La relación no está activa hasta que se apruebe
            upf.setPuntos(0);
            upf.setIdFamilia(familia.getIdFamilia());
            upf.setDni(user.getDni());

            try {
                usuarioPerteneceFamiliaController.create(upf);
                crearNotificacion(dniAdmin, user.getDni());
                JOptionPane.showMessageDialog(null, "Solicitud enviada correctamente a la familia " + familia.getNombre(), "Solicitud Enviada", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al enviar la solicitud.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ninguna familia con el DNI del administrador proporcionado.", "Familia No Encontrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void crearNotificacion(String dniAdmin, String destinatario) {
        Notificaciones nuevaNotificacion = new Notificaciones();
        nuevaNotificacion.setTitulo("Solicitud de ingreso");
        nuevaNotificacion.setCuerpo("Un usuario ha solicitado acceso a tu familia.");
        nuevaNotificacion.setDniAdmin(dniAdmin);
        nuevaNotificacion.setDestinatario(destinatario);
        nuevaNotificacion.setFechaHora(new Date());  // Fecha y hora actuales
        nuevaNotificacion.setLeido(false);  // Inicialmente, la notificación no está leída

        try {
            notCont.create(nuevaNotificacion);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deactivatePremio(UsuarioReclamaPremios premioActivo) throws Exception {
        premioActivo.setActivo(false);
        urpCont.edit(premioActivo);
    }

    public UsuarioReclamaPremios findPremioActivoPorId(UsuarioReclamaPremiosId urpId) {
        return urpCont.findUsuarioReclamaPremios(urpId);
    }

    public UsuarioHaceTareas findUsuarioHaceTareas(UsuarioHaceTareasId uhtId) {
        return uhtCont.findUsuarioHaceTareas(uhtId);
    }

    public void editarUsuarioHaceTareas(UsuarioHaceTareas uht) throws Exception {
        uhtCont.edit(uht);
    }

    public boolean esAdministrador(String dni, int idFamilia) {
        // Simula una búsqueda que determina si el usuario es administrador
        // Esto debería hacer una consulta a la base de datos o verificar un estado
        Familia familia = famCont.findFamiliaById(idFamilia);
        return familia.getDniAdmin().equals(dni);
    }

    public void sumarPuntosAupf(int puntos, String dni, int IdFam) {
        UsuarioPerteneceFamiliaPK upfPK = new UsuarioPerteneceFamiliaPK(dni, IdFam);
        UsuarioPerteneceFamilia upf = usuarioPerteneceFamiliaController.findUsuarioPerteneceFamilia(upfPK);
        int puntosAntes = upf.getPuntos();
        upf.setPuntos(puntosAntes + puntos);
        try {
            usuarioPerteneceFamiliaController.edit(upf);
        } catch (Exception ex) {
            Logger.getLogger(ServicioAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void LeerNotificacion(Notificaciones notificacion) throws Exception {
        notCont.edit(notificacion);
    }

    public UsuarioPerteneceFamilia refreshEntity(UsuarioPerteneceFamiliaPK upfPk) {
        EntityManager em = emf.createEntityManager();
        UsuarioPerteneceFamilia upf = null;
        try {
            em.getTransaction().begin();
            upf = em.find(UsuarioPerteneceFamilia.class, upfPk);
            em.refresh(upf); // Refresca la entidad con la última versión de la base de datos.
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw ex;
        } finally {
            em.close();
        }
        return upf; // Retorna la entidad refrescada.
    }

}
