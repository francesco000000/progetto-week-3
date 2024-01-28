package it.epicode.dao;

import it.epicode.entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UtenteDao {
    private EntityManagerFactory emf;
    private EntityManager em;

    public UtenteDao(){
        emf = Persistence.createEntityManagerFactory("week3");
        em = emf.createEntityManager();
    }
    public void save(Utente u){
        EntityTransaction et = em.getTransaction();
        et.begin();

        em.persist(u);

        et.commit();
    }

    public Utente getById(int id){
        return em.find(Utente.class, id);
    }

    public void delete(int id){
        EntityTransaction et = em.getTransaction();
        et.begin();

        Utente u = getById(id);
        em.remove(u);
        et.commit();
    }

    public void close(){
        em.close();
        emf.close();
    }

}
