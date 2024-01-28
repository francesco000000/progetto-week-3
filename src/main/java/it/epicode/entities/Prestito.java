package it.epicode.entities;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;
@Entity
@Table(name="prestiti")
@NamedQuery(name = "getElementiInPrestito", query = "SELECT p.ElementoPrestato FROM Prestito p WHERE p.utente.numeroTessera = :numeroTessera")
@NamedQuery(name = "getPrestitoScaduto", query = "SELECT p.ElementoPrestato FROM Prestito p WHERE p.dataRestituzionePrestito>LocalaDate.naw() and p.restituzioneEffetiva IS NULL  ")
public class Prestito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "libro_id")

    private ElementoEditoriale ElementoPrestato;
    @Column(name = "data_inizio_prestito")
    private LocalDate dataInizioPrestito;
    @Column(name = "data_restituzione_prestito")
    private LocalDate dataRestituzionePrestito;
    @Column(name = "restituzione_effettiva")
    private LocalDate restituzioneEffettiva;
    @ManyToOne
    @JoinColumn(name = "utente_fk")
   private Utente utente;

    public Prestito (){

    }

    public Prestito(int id, ElementoEditoriale elementoPrestato, LocalDate dataInizioPrestito, LocalDate dataRestituzionePrestito, LocalDate restituzioneEffettiva) {
        this.id = id;
        ElementoPrestato = elementoPrestato;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzionePrestito = restituzionePrestito();
        this.restituzioneEffettiva = restituzioneEffettiva;
    }
    public LocalDate restituzionePrestito(){
        dataRestituzionePrestito= dataInizioPrestito.plusDays(30);
        return dataRestituzionePrestito;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ElementoEditoriale getElementoPrestato() {
        return ElementoPrestato;
    }

    public void setElementoPrestato(ElementoEditoriale elementoPrestato) {
        ElementoPrestato = elementoPrestato;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public LocalDate getDataRestituzionePrestito() {
        return dataRestituzionePrestito;
    }

    public void setDataRestituzionePrestito(LocalDate dataRestituzionePrestito) {
        this.dataRestituzionePrestito = dataRestituzionePrestito;
    }

    public LocalDate getRestituzioneEffettiva() {
        return restituzioneEffettiva;
    }

    public void setRestituzioneEffettiva(LocalDate restituzioneEffettiva) {
        this.restituzioneEffettiva = restituzioneEffettiva;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", ElementoPrestato='" + ElementoPrestato + '\'' +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", dataRestituzionePrestito=" + dataRestituzionePrestito +
                ", restituzioneEffettiva=" + restituzioneEffettiva +
                ", utente=" + utente +
                '}';
    }
}
