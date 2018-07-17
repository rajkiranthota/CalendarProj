/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rajk.dao;

import com.rajk.dao.exceptions.NonexistentEntityException;
import com.rajk.dao.exceptions.PreexistingEntityException;
import com.rajk.model.CalendarEvents;
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
public class CalendarEventsJpaController implements Serializable {

    public CalendarEventsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CalendarEvents calendarEvents) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(calendarEvents);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCalendarEvents(calendarEvents.getCeventId()) != null) {
                throw new PreexistingEntityException("CalendarEvents " + calendarEvents + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CalendarEvents calendarEvents) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            calendarEvents = em.merge(calendarEvents);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = calendarEvents.getCeventId();
                if (findCalendarEvents(id) == null) {
                    throw new NonexistentEntityException("The calendarEvents with id " + id + " no longer exists.");
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
            CalendarEvents calendarEvents;
            try {
                calendarEvents = em.getReference(CalendarEvents.class, id);
                calendarEvents.getCeventId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The calendarEvents with id " + id + " no longer exists.", enfe);
            }
            em.remove(calendarEvents);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CalendarEvents> findCalendarEventsEntities() {
        return findCalendarEventsEntities(true, -1, -1);
    }

    public List<CalendarEvents> findCalendarEventsEntities(int maxResults, int firstResult) {
        return findCalendarEventsEntities(false, maxResults, firstResult);
    }

    private List<CalendarEvents> findCalendarEventsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CalendarEvents.class));
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

    public CalendarEvents findCalendarEvents(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CalendarEvents.class, id);
        } finally {
            em.close();
        }
    }

    public int getCalendarEventsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CalendarEvents> rt = cq.from(CalendarEvents.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
