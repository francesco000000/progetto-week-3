package it.epicode.dao;

import it.epicode.entities.Catalogo;
import it.epicode.entities.ElementoEditoriale;
import it.epicode.entities.Libro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CatalogoDao {
    private EntityManagerFactory emf;
    private EntityManager em;

    public CatalogoDao(){
        emf = Persistence.createEntityManagerFactory("week3");
        em = emf.createEntityManager();
    }

    public void save(ElementoEditoriale e){
        EntityTransaction et = em.getTransaction();
        et.begin();

        em.persist(e);

        et.commit();
    }

    public ElementoEditoriale getById(int id){
        return em.find(ElementoEditoriale.class, id);
    }

    public void delete(int id){
        EntityTransaction et = em.getTransaction();
        et.begin();

        ElementoEditoriale e = getById(id);
        em.remove(e);
        et.commit();
    }

    public void close(){
        em.close();
        emf.close();
    }

}
