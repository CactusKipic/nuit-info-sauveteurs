package fr.cactus_industries.nuit_info_sauveteurs.database.interaction.service;

import fr.cactus_industries.nuit_info_sauveteurs.database.schema.table.TSauve;

import java.util.List;
import java.util.Optional;

public interface SauveService {
    
    TSauve save(TSauve s);
    
    List<TSauve> findAll();
    
    List<TSauve> findAllById(List<Long> sauves);
    
    Optional<TSauve> findById(long id);
    
    List<TSauve> searchByName(String value);
}
