package fr.cactus_industries.nuit_info_sauveteurs.database.interaction.repository;

import fr.cactus_industries.nuit_info_sauveteurs.database.schema.table.TSauve;
import fr.cactus_industries.nuit_info_sauveteurs.database.schema.table.TSauveBySauvetage;
import fr.cactus_industries.nuit_info_sauveteurs.database.schema.table.TSauveBySauvetagePK;
import fr.cactus_industries.nuit_info_sauveteurs.database.schema.table.TSauvetage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SauveBySauvetageRepository extends JpaRepository<TSauveBySauvetage, TSauveBySauvetagePK> {
    
    @Query("SELECT tbl FROM TSauveBySauvetage AS tbl " +
            "WHERE tbl.idSauvetage = :#{#sauvetage.id}")
    List<TSauveBySauvetage> getSauveOfSauvetage(@Param("sauvetage") TSauvetage sauvetage);
    
    @Query("SELECT tbl FROM TSauveBySauvetage AS tbl " +
            "WHERE tbl.idSauve = :#{#sauve.id}")
    List<TSauveBySauvetage> getSauvetageOfSauve(@Param("sauve") TSauve sauve);
    
}
