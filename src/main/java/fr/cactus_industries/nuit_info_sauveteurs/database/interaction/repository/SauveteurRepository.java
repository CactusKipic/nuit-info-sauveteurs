package fr.cactus_industries.nuit_info_sauveteurs.database.interaction.repository;

import fr.cactus_industries.nuit_info_sauveteurs.database.schema.table.TSauveteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SauveteurRepository extends JpaRepository<TSauveteur, Long> {
    
    @Query("SELECT tbl FROM TSauveteur AS tbl " +
            "WHERE lower(tbl.nom) LIKE lower(concat('%',:value,'%')) OR lower(tbl.prenom) LIKE lower(concat('%',:value,'%')) ")
    List<TSauveteur> searchSauveteurByNameIgnoreCase(@Param("value")String value);
    
}
