package fr.cactus_industries.nuit_info_sauveteurs.database.interaction.repository;

import fr.cactus_industries.nuit_info_sauveteurs.database.schema.table.TSauve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SauveRepository extends JpaRepository<TSauve, Long> {
    
    @Query("SELECT tbl FROM TSauve AS tbl " +
            "WHERE lower(tbl.nom) LIKE lower(concat('%',:value,'%')) OR lower(tbl.prenom) LIKE lower(concat('%',:value,'%')) ")
    List<TSauve> searchSauveByNameIgnoreCase(@Param("value")String value);
    
}
