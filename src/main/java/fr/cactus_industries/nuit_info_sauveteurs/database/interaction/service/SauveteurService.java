package fr.cactus_industries.nuit_info_sauveteurs.database.interaction.service;

import fr.cactus_industries.nuit_info_sauveteurs.database.schema.table.TSauveteur;

import java.util.List;
import java.util.Optional;

public interface SauveteurService {
    
    TSauveteur save(TSauveteur s);
    
    List<TSauveteur> findAll();
    
    List<TSauveteur> findAllById(List<Long> sauveteurs);
    
    Optional<TSauveteur> findById(long id);
    
    List<TSauveteur> searchByName(String value);
}
