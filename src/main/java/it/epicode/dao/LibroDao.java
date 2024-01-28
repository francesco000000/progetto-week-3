package it.epicode.dao;

import it.epicode.entities.Libro;
import it.epicode.entities.Rivista;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

public class LibroDao
{
    private EntityManagerFactory emf;
    private EntityManager em;

    public LibroDao(){
        emf = Persistence.createEntityManagerFactory("week3");
        em = emf.createEntityManager();
    }

    public void save(Libro l){
        EntityTransaction et = em.getTransaction();
        et.begin();

        em.persist(l);

        et.commit();
    }

    public Libro getById(int id){
        return em.find(Libro.class, id);
    }

    public void delete(int id){
        EntityTransaction et = em.getTransaction();
        et.begin();

        Libro l = getById(id);
        em.remove(l);
        et.commit();
    }

    public void close(){
        em.close();
        emf.close();
    }
   public  List<Libro> getLibroPerAnno(LocalDate anno){
       Query q = em.createNamedQuery("getLibroPerAnno");
       return q.getResultList();
   }
    public  List<Libro> getLibroPerAutore(String autore){
        Query q = em.createNamedQuery("getLibroPerAutore");
        return q.getResultList();
    }
    public  List<Libro> getLibroPerTitolo(String autore){
        Query q = em.createNamedQuery("getLibroPerTitolo");
        return q.getResultList();
    }


}
