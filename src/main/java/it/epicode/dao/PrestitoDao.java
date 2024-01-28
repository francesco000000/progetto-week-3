package it.epicode.dao;

import it.epicode.entities.ElementoEditoriale;
import it.epicode.entities.Prestito;
import it.epicode.entities.Rivista;

import javax.persistence.*;
import java.util.List;

public class PrestitoDao {
    private EntityManagerFactory emf;
    private EntityManager em;

    public PrestitoDao(){
        emf = Persistence.createEntityManagerFactory("week3");
        em = emf.createEntityManager();
    }

    public void save(Prestito p){
        EntityTransaction et = em.getTransaction();
        et.begin();

        em.persist(p);

        et.commit();
    }

    public Prestito getById(int id){
        return em.find(Prestito.class, id);
    }

    public void delete(int id){
        EntityTransaction et = em.getTransaction();
        et.begin();

       Prestito p = getById(id);
        em.remove(p);
        et.commit();
    }

    public void close(){
        em.close();
        emf.close();
    }
public List<ElementoEditoriale> getElementiInPrestito( int numeroTessera){
    Query q = em.createNamedQuery("getElementiInPrestito");
    return q.getResultList();
}
    public List<Prestito> getPrestitoScaduto( ){
        Query q = em.createNamedQuery("getPrestitoScaduto");
        return q.getResultList();
    }

}
