package fr.cactus_industries.nuit_info_sauveteurs.database.interaction.repository;

import fr.cactus_industries.nuit_info_sauveteurs.database.schema.table.TSauvetage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface SauvetageRepository extends JpaRepository<TSauvetage, Long> {
    
    @Query("SELECT tbl FROM TSauvetage AS tbl " +
            "WHERE lower(tbl.nom) LIKE lower(concat('%',:value,'%'))")
    List<TSauvetage> searchSauvetageByNameIgnoreCase(@Param("value")String value);
    
    @Query("SELECT tbl FROM TSauvetage  AS tbl " +
            "WHERE tbl.date >= :start AND tbl.date <= :end")
    List<TSauvetage> searchBetweenDate(@Param("start")Date start, @Param("end")Date end);
    
    @Query("SELECT tbl FROM TSauvetage  AS tbl " +
            "WHERE tbl.date >= :start AND tbl.date <= :end " +
            "AND lower(tbl.nom) LIKE lower(concat('%',:value,'%'))")
    List<TSauvetage> searchBetweenDateAndName(@Param("start")Date start, @Param("end")Date end, @Param("value")String value);
    
}
