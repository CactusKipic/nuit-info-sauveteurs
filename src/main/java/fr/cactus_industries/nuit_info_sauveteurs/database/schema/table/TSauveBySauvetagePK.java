package fr.cactus_industries.nuit_info_sauveteurs.database.schema.table;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class TSauveBySauvetagePK implements Serializable {
    @Id
    @Column(name = "id_sauvetage", nullable = false, updatable = false)
    private long idSauvetage;
    @Id
    @Column(name = "id_sauve", nullable = false, updatable = false)
    private long idSauve;
    
    public long getIdSauvetage() {
        return idSauvetage;
    }
    
    public void setIdSauvetage(long idSauvetage) {
        this.idSauvetage = idSauvetage;
    }
    
    public long getIdSauve() {
        return idSauve;
    }
    
    public void setIdSauve(long idSauve) {
        this.idSauve = idSauve;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TSauveBySauvetagePK that = (TSauveBySauvetagePK) o;
        return idSauvetage == that.idSauvetage && idSauve == that.idSauve;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(idSauvetage, idSauve);
    }
}
