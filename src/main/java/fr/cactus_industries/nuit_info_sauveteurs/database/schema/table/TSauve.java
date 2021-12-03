package fr.cactus_industries.nuit_info_sauveteurs.database.schema.table;

import com.fasterxml.jackson.annotation.JsonAlias;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sauve", schema = "public", catalog = "nuit_info_sauveteurs")
public class TSauve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JsonAlias("_id")
    private long id;
    @Basic
    @Column(name = "nom", length = 64)
    @JsonAlias("_nom")
    private String nom;
    @Basic
    @Column(name = "prenom", length = 128)
    @JsonAlias("_prenom")
    private String prenom;
    @Basic
    @Column(name = "valide", nullable = false)
    @JsonAlias("_valide")
    private boolean valide;
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getPrenom() {
        return prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public boolean isValide() {
        return valide;
    }
    
    public void setValide(boolean valide) {
        this.valide = valide;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TSauve tSauve = (TSauve) o;
        return id == tSauve.id && valide == tSauve.valide && Objects.equals(nom, tSauve.nom) && Objects.equals(prenom, tSauve.prenom);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prenom, valide);
    }
}
