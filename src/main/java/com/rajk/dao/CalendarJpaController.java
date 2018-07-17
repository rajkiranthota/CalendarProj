/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rajk.dao;

import com.rajk.dao.exceptions.NonexistentEntityException;
import com.rajk.dao.exceptions.PreexistingEntityException;
import com.rajk.model.Calendar;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Rajkiran_Macys
 */
public class CalendarJpaController implements Serializable {

    public CalendarJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Calendar calendar) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(calendar);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCalendar(calendar.getCid()) != null) {
                throw new PreexistingEntityException("Calendar " + calendar + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Calendar calendar) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            calendar = em.merge(calendar);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = calendar.getCid();
                if (findCalendar(id) == null) {
                    throw new NonexistentEntityException("The calendar with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Calendar calendar;
            try {
                calendar = em.getReference(Calendar.class, id);
                calendar.getCid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The calendar with id " + id + " no longer exists.", enfe);
            }
            em.remove(calendar);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Calendar> findCalendarEntities() {
        return findCalendarEntities(true, -1, -1);
    }

    public List<Calendar> findCalendarEntities(int maxResults, int firstResult) {
        return findCalendarEntities(false, maxResults, firstResult);
    }

    private List<Calendar> findCalendarEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Calendar.class));
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

    public Calendar findCalendar(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Calendar.class, id);
        } finally {
            em.close();
        }
    }

    public int getCalendarCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Calendar> rt = cq.from(Calendar.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
