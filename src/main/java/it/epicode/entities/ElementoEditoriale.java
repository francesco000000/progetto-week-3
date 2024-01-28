package it.epicode.entities;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class  ElementoEditoriale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int isbn;
    private String titolo;
    @Column(name = "anno_publicazione")
    private LocalDate annoPublicazione;
    @Column(name = "numero_pagine")
    private  int numeroPagine;
    @ManyToOne
    @JoinColumn(name = "catalogo_fk")
    private Catalogo catalogo;


    public ElementoEditoriale(int isbn, String titolo, LocalDate annoPublicazione, int numeroPagine, Catalogo catalogo) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.annoPublicazione = annoPublicazione;
        this.numeroPagine = numeroPagine;
        this.catalogo = catalogo;
    }

    public ElementoEditoriale(int isbn, String titolo, LocalDate annoPublicazione, int numeroPagine ) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.annoPublicazione = annoPublicazione;
        this.numeroPagine = numeroPagine;

    }

    public ElementoEditoriale() {

    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getAnnoPublicazione() {
        return annoPublicazione;
    }

    public void setAnnoPublicazione(LocalDate annoPublicazione) {
        this.annoPublicazione = annoPublicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }


    @Override
    public String toString() {
        return "ElementoEditoriale{" +
                "isbn=" + isbn +
                ", titolo='" + titolo + '\'' +
                ", annoPublicazione=" + annoPublicazione +
                ", numeroPagine=" + numeroPagine +
                ", catalogo=" + catalogo +
                '}';
    }
}

