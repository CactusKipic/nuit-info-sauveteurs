package fr.cactus_industries.nuit_info_sauveteurs.database.schema.table;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sauveteur_by_sauvetage", schema = "public", catalog = "nuit_info_sauveteurs")
@IdClass(TSauveteurBySauvetagePK.class)
public class TSauveteurBySauvetage {
    @Id
    @JoinColumn(name = "id_sauvetage", referencedColumnName = "id", table = "sauvetage", nullable = false, updatable = false)
    private long idSauvetage;
    @Id
    @JoinColumn(name = "id_sauveteur", referencedColumnName = "id", table = "sauveteur", nullable = false, updatable = false)
    private long idSauveteur;
    
    public TSauveteurBySauvetage(Long idSauvetage, Long idsauveteur) {
        this.idSauvetage = idSauvetage;
        this.idSauveteur =idsauveteur;
    }
    
    public TSauveteurBySauvetage() {
    
    }
    
    public long getIdSauvetage() {
        return idSauvetage;
    }
    
    public void setIdSauvetage(long idSauvetage) {
        this.idSauvetage = idSauvetage;
    }
    
    public long getIdSauveteur() {
        return idSauveteur;
    }
    
    public void setIdSauveteur(long idSauveteur) {
        this.idSauveteur = idSauveteur;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TSauveteurBySauvetage that = (TSauveteurBySauvetage) o;
        return idSauvetage == that.idSauvetage && idSauveteur == that.idSauveteur;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(idSauvetage, idSauveteur);
    }
}
