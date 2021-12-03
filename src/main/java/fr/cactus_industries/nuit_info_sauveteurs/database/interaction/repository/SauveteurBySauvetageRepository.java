package fr.cactus_industries.nuit_info_sauveteurs.database.interaction.repository;

import fr.cactus_industries.nuit_info_sauveteurs.database.schema.table.TSauvetage;
import fr.cactus_industries.nuit_info_sauveteurs.database.schema.table.TSauveteur;
import fr.cactus_industries.nuit_info_sauveteurs.database.schema.table.TSauveteurBySauvetage;
import fr.cactus_industries.nuit_info_sauveteurs.database.schema.table.TSauveteurBySauvetagePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SauveteurBySauvetageRepository extends JpaRepository<TSauveteurBySauvetage, TSauveteurBySauvetagePK> {
    
    @Query("SELECT tbl FROM TSauveteurBySauvetage AS tbl " +
            "WHERE tbl.idSauvetage = :#{#sauvetage.id}")
    List<TSauveteurBySauvetage> getSauveteurOfSauvetage(@Param("sauvetage") TSauvetage sauvetage);
    
    @Query("SELECT tbl FROM TSauveteurBySauvetage AS tbl " +
            "WHERE tbl.idSauveteur = :#{#sauveteur.id}")
    List<TSauveteurBySauvetage> getSauvetageOfSauve(@Param("sauveteur") TSauveteur sauveteur);
}
