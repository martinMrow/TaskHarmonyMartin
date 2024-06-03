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
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.criteria.CriteriaQuery;

public class UsuarioHaceTareasJpaController {

    private EntityManagerFactory emf;

    public UsuarioHaceTareasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(UsuarioHaceTareas usuarioHaceTareas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(usuarioHaceTareas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(UsuarioHaceTareas usuarioHaceTareas) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            usuarioHaceTareas = em.merge(usuarioHaceTareas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                UsuarioHaceTareasId id = new UsuarioHaceTareasId(usuarioHaceTareas.getDni(), usuarioHaceTareas.getIdTarea(), usuarioHaceTareas.getFechaRealizada());
                if (findUsuarioHaceTareas(id) == null) {
                    throw new Exception("The usuarioHaceTareas with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

   

    public void destroy(UsuarioHaceTareasId id) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            UsuarioHaceTareas usuarioHaceTareas;
            try {
                usuarioHaceTareas = em.getReference(UsuarioHaceTareas.class, id);
                em.remove(usuarioHaceTareas);
            } catch (EntityNotFoundException enfe) {
                throw new Exception("The usuarioHaceTareas with id " + id + " no longer exists.", enfe);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public UsuarioHaceTareas findUsuarioHaceTareas(UsuarioHaceTareasId id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UsuarioHaceTareas.class, id);
        } finally {
            em.close();
        }
    }

    public List<UsuarioHaceTareas> findAllUsuarioHaceTareas() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UsuarioHaceTareas.class));
            Query q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
}
