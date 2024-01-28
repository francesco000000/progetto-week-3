package it.epicode.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="cataloghi")

public class Catalogo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
private int id;
    @OneToMany(mappedBy = "catalogo")

    private List<ElementoEditoriale> catalogo = new ArrayList<>();

public Catalogo(){

}

    public Catalogo(int id) {
        this.id = id;
        this.catalogo = catalogo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ElementoEditoriale> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(List<ElementoEditoriale> catalogo) {
        this.catalogo = catalogo;
    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "id=" + id +
                ", catalogo=" + catalogo +
                '}';
    }
}
