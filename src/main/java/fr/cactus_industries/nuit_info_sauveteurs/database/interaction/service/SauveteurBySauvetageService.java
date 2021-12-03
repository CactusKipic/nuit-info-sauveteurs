package fr.cactus_industries.nuit_info_sauveteurs.database.interaction.service;


import fr.cactus_industries.nuit_info_sauveteurs.database.schema.table.TSauvetage;
import fr.cactus_industries.nuit_info_sauveteurs.database.schema.table.TSauveteur;
import fr.cactus_industries.nuit_info_sauveteurs.database.schema.table.TSauveteurBySauvetage;

import java.util.List;

public interface SauveteurBySauvetageService {
    
    TSauveteurBySauvetage save(TSauveteurBySauvetage s);
    
    List<TSauveteurBySauvetage> findAll();
    
    List<TSauveteurBySauvetage> findAllBySauvetage(TSauvetage sauvetage);
    
    List<TSauveteurBySauvetage> findAllBySauveteur(TSauveteur sauveteur);
}
