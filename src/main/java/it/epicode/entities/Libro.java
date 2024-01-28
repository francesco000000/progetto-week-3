package it.epicode.entities;

import it.epicode.entities.ElementoEditoriale;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "libri")
@NamedQuery(name = "getLibroPerAnno", query = "SELECT l FROM Libro l WHERE l.annoPubblicazione = :anno")
@NamedQuery(name = "getLibroPerAutore", query = "SELECT l FROM Libro l WHERE l.autore = :autore")
@NamedQuery(name = "getLibroPerTitolo", query = "SELECT l FROM Libro l WHERE  LIKE =:titolo%")

public class Libro extends ElementoEditoriale {
    private String autore;
    private String genere;



    public Libro (){
        super();

    }

    public Libro(int isbn, String titolo, LocalDate annoPublicazione, int numeroPagine, Catalogo catalogo, String autore, String genere) {
        super(isbn, titolo, annoPublicazione, numeroPagine, catalogo);
        this.autore = autore;
        this.genere = genere;
    }

    public Libro(int isbn, String titolo, LocalDate annoPublicazione, int numeroPagine, String autore, String genere, Catalogo catalogo) {
        super(isbn, titolo, annoPublicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;

    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }




    }

