package fr.cactus_industries.nuit_info_sauveteurs.database.schema.table;

import com.fasterxml.jackson.annotation.JsonAlias;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "sauvetage", schema = "public", catalog = "nuit_info_sauveteurs")
public class TSauvetage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JsonAlias("_id")
    private long id;
    @Basic
    @Column(name = "date", nullable = false)
    @JsonAlias("_date")
    private Date date;
    @Basic
    @Column(name = "nom", nullable = false)
    @JsonAlias("_nom")
    private String nom;
    @Basic
    @Column(name = "description", nullable = false)
    @JsonAlias("_description")
    private String description;
    @Basic
    @Column(name = "source", nullable = false)
    @JsonAlias("_source")
    private String source;
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
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getSource() {
        return source;
    }
    
    public void setSource(String source) {
        this.source = source;
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
        TSauvetage that = (TSauvetage) o;
        return id == that.id && valide == that.valide && date.equals(that.date) && nom.equals(that.nom) && description.equals(that.description) && source.equals(that.source);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, date, nom, description, source, valide);
    }
}
