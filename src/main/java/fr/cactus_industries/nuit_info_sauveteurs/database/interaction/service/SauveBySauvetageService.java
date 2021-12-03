package fr.cactus_industries.nuit_info_sauveteurs.database.interaction.service;

import fr.cactus_industries.nuit_info_sauveteurs.database.schema.table.TSauve;
import fr.cactus_industries.nuit_info_sauveteurs.database.schema.table.TSauveBySauvetage;
import fr.cactus_industries.nuit_info_sauveteurs.database.schema.table.TSauvetage;

import java.util.List;

public interface SauveBySauvetageService {
    
    TSauveBySauvetage save(TSauveBySauvetage s);
    
    List<TSauveBySauvetage> findAll();
    
    List<TSauveBySauvetage> findAllBySauvetage(TSauvetage sauvetage);
    
    List<TSauveBySauvetage> findAllBySauve(TSauve sauve);
}
