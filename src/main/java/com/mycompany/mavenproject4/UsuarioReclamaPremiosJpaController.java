/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject4;

/**
 *
 * @author tetra
 */
import java.util.Date;
import javax.persistence.*;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;

public class UsuarioReclamaPremiosJpaController {

    private EntityManagerFactory emf;

    public UsuarioReclamaPremiosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(UsuarioReclamaPremios usuarioReclamaPremios) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(usuarioReclamaPremios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(UsuarioReclamaPremios usuarioReclamaPremios) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            usuarioReclamaPremios = em.merge(usuarioReclamaPremios);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                UsuarioReclamaPremiosId id = new UsuarioReclamaPremiosId(usuarioReclamaPremios.getDni(), usuarioReclamaPremios.getIdPremio(), usuarioReclamaPremios.getReclamado());
                if (findUsuarioReclamaPremios(id) == null) {
                    throw new Exception("The UsuarioReclamaPremios with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(UsuarioReclamaPremiosId id) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            UsuarioReclamaPremios usuarioReclamaPremios;
            try {
                usuarioReclamaPremios = em.getReference(UsuarioReclamaPremios.class, id);
                em.remove(usuarioReclamaPremios);
            } catch (EntityNotFoundException enfe) {
                throw new Exception("The UsuarioReclamaPremios with id " + id + " no longer exists.", enfe);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public UsuarioReclamaPremios findUsuarioReclamaPremios(UsuarioReclamaPremiosId id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UsuarioReclamaPremios.class, id);
        } finally {
            em.close();
        }
    }

    public void updatePremiosActivos() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            // Consulta para encontrar todos los premios reclamados que estÃ¡n actualmente activos
            TypedQuery<UsuarioReclamaPremios> query = em.createQuery(
                    "SELECT urp FROM UsuarioReclamaPremios urp WHERE urp.activo = true", UsuarioReclamaPremios.class);
            List<UsuarioReclamaPremios> resultados = query.getResultList();

            Date hoy = new Date();
            boolean cambios = false;

            for (UsuarioReclamaPremios urp : resultados) {
                // Asumiendo que la duraciÃ³n del premio estÃ¡ almacenada y es accesible
                Premios premio = em.find(Premios.class, urp.getIdPremio());
                if (premio != null && premio.getDuracion() != null) {
                    // Calcular la fecha de expiraciÃ³n del premio
                    Date fechaExpiracion = new Date(urp.getReclamado().getTime() + (long) premio.getDuracion() * 24 * 3600 * 1000);
                    if (hoy.after(fechaExpiracion)) {
                        urp.setActivo(false);
                        em.merge(urp);
                        cambios = true;
                    }
                }
            }

            if (cambios) {
                em.getTransaction().commit();
            } else {
                em.getTransaction().rollback();
            }
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<UsuarioReclamaPremios> findAllUsuarioReclamaPremios() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UsuarioReclamaPremios.class));
            Query q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            em.close();
        }

    }
}
