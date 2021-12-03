package fr.cactus_industries.nuit_info_sauveteurs.database.schema.table;

import com.fasterxml.jackson.annotation.JsonAlias;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sauveteur", schema = "public", catalog = "nuit_info_sauveteurs")
public class TSauveteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JsonAlias("_id")
    private long id;
    @Basic
    @Column(name = "nom", length = 64, columnDefinition = "varchar")
    @JsonAlias("_nom")
    private String nom;
    @Basic
    @Column(name = "prenom", length = 128)
    @JsonAlias("_prenom")
    private String prenom;
    @Basic
    @Column(name = "biographie", nullable = false)
    @JsonAlias("_biographie")
    private String biographie;
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
    
    public String getBiographie() {
        return biographie;
    }
    
    public void setBiographie(String biograpgie) {
        this.biographie = biograpgie;
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
        TSauveteur that = (TSauveteur) o;
        return id == that.id && valide == that.valide && Objects.equals(nom, that.nom) && Objects.equals(prenom, that.prenom) && biographie.equals(that.biographie);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prenom, biographie, valide);
    }
}
