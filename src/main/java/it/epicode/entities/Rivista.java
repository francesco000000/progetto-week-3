package it.epicode.entities;

import it.epicode.entities.ElementoEditoriale;
import it.epicode.entities.Periodicita;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "riviste")
@NamedQuery(name = "getRivistaPerAnno", query = "SELECT r FROM Rivista r WHERE l.annoPubblicazione = :anno")
@NamedQuery(name = "getRivistaPerAutore", query = "SELECT r FROM Rivista r WHERE l.autore = :autore")
@NamedQuery(name = "getRivistaPerTitolo", query = "SELECT r FROM Rivista r WHERE  LIKE =:titolo%")
public class Rivista extends ElementoEditoriale {

    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;


    public Rivista (){

    }

    public Rivista(int isbn, String titolo, LocalDate annoPublicazione, int numeroPagine, Catalogo catalogo, Periodicita periodicita) {
        super(isbn, titolo, annoPublicazione, numeroPagine, catalogo);
        this.periodicita = periodicita;
    }

    public Rivista(int isbn, String titolo, LocalDate annoPublicazione, int numeroPagine, Periodicita periodicita, Catalogo catalogo) {
        super(isbn, titolo, annoPublicazione, numeroPagine);
        this.periodicita = periodicita;

    }





    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "periodicita=" + periodicita +
                "} " + super.toString();
    }
}
