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
import javax.persistence.*;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import javax.persistence.*;
import java.util.List;

import javax.persistence.*;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;

public class TareasJpaController {

    private EntityManagerFactory emf = null;

    public TareasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tareas tarea) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tarea);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tareas tarea) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tarea = em.merge(tarea);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception("La tarea con id " + tarea.getIdTarea() + " no existe.", ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tareas tarea;
            try {
                tarea = em.getReference(Tareas.class, id);
                tarea.getIdTarea();
            } catch (EntityNotFoundException enfe) {
                throw new Exception("La tarea con id " + id + " no existe.", enfe);
            }
            em.remove(tarea);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tareas> findTareasEntities() {
        return findTareasEntities(true, -1, -1);
    }

    public List<Tareas> findTareasEntities(int maxResults, int firstResult) {
        return findTareasEntities(false, maxResults, firstResult);
    }

    private List<Tareas> findTareasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tareas.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Tareas findTareas(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tareas.class, id);
        } finally {
            em.close();
        }
    }

    public int getTareasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tareas> rt = cq.from(Tareas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<Tareas> findActiveTareasByFamilia(int idFamilia) {
        EntityManager em = getEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Tareas> cq = cb.createQuery(Tareas.class);
            Root<Tareas> tareas = cq.from(Tareas.class);
            cq.select(tareas).where(cb.and(
                    cb.equal(tareas.get("idFamilia"), idFamilia),
                    cb.isTrue(tareas.get("activo"))
            ));
            Query q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Tareas> findTareasByFamilia(int idFamilia) {
        EntityManager em = getEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Tareas> cq = cb.createQuery(Tareas.class);
            Root<Tareas> tareas = cq.from(Tareas.class);
            cq.select(tareas).where(cb.and(
                    cb.equal(tareas.get("idFamilia"), idFamilia)
            ));
            Query q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            em.close();
        }
    }
}
