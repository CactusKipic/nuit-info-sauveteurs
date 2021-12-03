package fr.cactus_industries.nuit_info_sauveteurs.database.schema.table;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import java.io.Serializable;
import java.util.Objects;

public class TSauveteurBySauvetagePK implements Serializable {
    @Id
    @Column(name = "id_sauvetage", nullable = false, updatable = false)
    private long idSauvetage;
    @Id
    @Column(name = "id_sauveteur",  nullable = false, updatable = false)
    private long idSauveteur;
    
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
        TSauveteurBySauvetagePK that = (TSauveteurBySauvetagePK) o;
        return idSauvetage == that.idSauvetage && idSauveteur == that.idSauveteur;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(idSauvetage, idSauveteur);
    }
}
