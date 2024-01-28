package it.epicode.dao;

import it.epicode.entities.Libro;
import it.epicode.entities.Rivista;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

public class RivistaDao {
    private EntityManagerFactory emf;
    private EntityManager em;

    public RivistaDao(){
        emf = Persistence.createEntityManagerFactory("week3");
        em = emf.createEntityManager();
    }
    public void save(Rivista e){
        EntityTransaction et = em.getTransaction();
        et.begin();

        em.persist(e);

        et.commit();
    }

    public Rivista getById(int id){
        return em.find(Rivista.class, id);
    }

    public void delete(int id){
        EntityTransaction et = em.getTransaction();
        et.begin();

        Rivista r = getById(id);
        em.remove(r);
        et.commit();
    }

    public void close(){
        em.close();
        emf.close();
    }
    public List<Rivista> getLibroPerAnno(LocalDate anno){
        Query q = em.createNamedQuery("getLibroPerAnno");
        return q.getResultList();
    }
    public  List<Rivista> getLibroPerAutore(String autore){
        Query q = em.createNamedQuery("getLibroPerAutore");
        return q.getResultList();
    }
    public  List<Rivista> getLibroPerTitolo(String autore){
        Query q = em.createNamedQuery("getLibroPerTitolo");
        return q.getResultList();
    }

}
