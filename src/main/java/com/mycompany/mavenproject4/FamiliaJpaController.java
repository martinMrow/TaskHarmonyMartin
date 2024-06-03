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
import com.mycompany.mavenproject4.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.*;
import java.util.List;

public class FamiliaJpaController {

    private EntityManagerFactory emf = null;

    public FamiliaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Método para crear familias
    public void create(Familia familia) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(familia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Método para editar familias
    public void edit(Familia familia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            familia = em.merge(familia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Método para eliminar familias por DNI del administrador
    public void destroyByDniAdmin(String dniAdmin) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Familia familia;
            try {
                // Intenta encontrar la familia directamente.
                familia = findFamiliaByDniAdmin(dniAdmin);
                if (familia == null) {
                    throw new NonexistentEntityException("The familia with dniAdmin " + dniAdmin + " no longer exists.");
                }
                // Reattach la familia usando merge antes de removerla.
                familia = em.merge(familia);
                em.remove(familia);
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The familia with dniAdmin " + dniAdmin + " no longer exists.", enfe);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Método para encontrar una familia por DNI del administrador
    public Familia findFamiliaByDniAdmin(String dniAdmin) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT f FROM Familia f WHERE f.dniAdmin = :dniAdmin", Familia.class)
                    .setParameter("dniAdmin", dniAdmin)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;  // Retorna null si no hay resultados
        } finally {
            em.close();
        }
    }

    public Familia findFamiliaById(int idFamilia) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("Familia.findById", Familia.class)
                    .setParameter("idFamilia", idFamilia) // Asegúrate de que el nombre del parámetro coincide
                    .getSingleResult();
        } finally {
            em.close();
        }
    }

    // Método para recuperar todas las familias
    public List<Familia> findAllFamilias() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Familia> query = em.createQuery("SELECT f FROM Familia f", Familia.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
