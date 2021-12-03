package fr.cactus_industries.nuit_info_sauveteurs.database.interaction.service;

import fr.cactus_industries.nuit_info_sauveteurs.database.schema.table.TSauvetage;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface SauvetageService {
    
    TSauvetage save(TSauvetage s);
    
    List<TSauvetage> findAll();
    
    List<TSauvetage> findAllById(List<Long> sauvetages);
    
    Optional<TSauvetage> findById(long id);
    
    List<TSauvetage> searchByName(String value);
    
    List<TSauvetage> searchBetweenDate(Date start, Date end);
    
    List<TSauvetage> searchBetweenDateAndName(Date start, Date end, String value);
}
