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

import javax.persistence.*;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class UsuarioPerteneceFamiliaJpaController {

    private EntityManagerFactory emf = null;

    public UsuarioPerteneceFamiliaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(UsuarioPerteneceFamilia upf) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(upf);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(UsuarioPerteneceFamilia upf) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            upf = em.merge(upf);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                UsuarioPerteneceFamiliaPK id = new UsuarioPerteneceFamiliaPK(upf.getDni(), upf.getIdFamilia());
                if (findUsuarioPerteneceFamilia(id) == null) {
                    throw new NonexistentEntityException("The usuarioPerteneceFamilia with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(UsuarioPerteneceFamiliaPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            UsuarioPerteneceFamilia upf;
            try {
                upf = em.getReference(UsuarioPerteneceFamilia.class, id);
                em.remove(upf);
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuarioPerteneceFamilia with id " + id + " no longer exists.", enfe);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public UsuarioPerteneceFamilia findUsuarioPerteneceFamilia(UsuarioPerteneceFamiliaPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UsuarioPerteneceFamilia.class, id);
        } finally {
            em.close();
        }
    }

    public List<UsuarioPerteneceFamilia> findAllUsuarioPerteneceFamilia() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UsuarioPerteneceFamilia.class));
            Query q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<UsuarioPerteneceFamilia> findActiveFamiliasByUsuario(String dni) {
        EntityManager em = getEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<UsuarioPerteneceFamilia> cq = cb.createQuery(UsuarioPerteneceFamilia.class);
            Root<UsuarioPerteneceFamilia> root = cq.from(UsuarioPerteneceFamilia.class);
            // Agregar criterio para que isActive sea true además de que el dni coincida
            Predicate conditionDni = cb.equal(root.get("dni"), dni);
            Predicate conditionIsActive = cb.isTrue(root.get("isActive"));
            cq.select(root).where(cb.and(conditionDni, conditionIsActive));
            Query q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<UsuarioPerteneceFamilia> findFamiliasByUsuario(String dni) {
        EntityManager em = getEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<UsuarioPerteneceFamilia> cq = cb.createQuery(UsuarioPerteneceFamilia.class);
            Root<UsuarioPerteneceFamilia> root = cq.from(UsuarioPerteneceFamilia.class);
            Predicate condition = cb.equal(root.get("dni"), dni);
            cq.select(root).where(condition);
            Query q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

}
