package fr.cactus_industries.nuit_info_sauveteurs.database.schema.table;

import com.fasterxml.jackson.annotation.JsonAlias;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sauve_by_sauvetage", schema = "public", catalog = "nuit_info_sauveteurs")
@IdClass(TSauveBySauvetagePK.class)
public class TSauveBySauvetage {
    @Id
    @JoinColumn(name = "id_sauvetage", referencedColumnName = "id", table = "sauvetage", nullable = false, updatable = false)
    private long idSauvetage;
    @Id
    @JoinColumn(name = "id_sauve", referencedColumnName = "id", table = "sauve", nullable = false, updatable = false)
    private long idSauve;
    
    public TSauveBySauvetage() {
    
    }
    
    public TSauveBySauvetage(long idSauvetage, long idSauve) {
        this.idSauvetage = idSauvetage;
        this.idSauve = idSauve;
    }
    
    public void setIdSauvetage(long idSauvetage) {
        this.idSauvetage = idSauvetage;
    }
    
    public void setIdSauve(long idSauve) {
        this.idSauve = idSauve;
    }
    
    public long getIdSauvetage() {
        return idSauvetage;
    }
    
    public long getIdSauve() {
        return idSauve;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TSauveBySauvetage that = (TSauveBySauvetage) o;
        return idSauvetage == that.idSauvetage && idSauve == that.idSauve;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(idSauvetage, idSauve);
    }
}
