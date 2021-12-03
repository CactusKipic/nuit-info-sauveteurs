package fr.cactus_industries.nuit_info_sauveteurs.database.interaction.service;

import fr.cactus_industries.nuit_info_sauveteurs.database.interaction.repository.SauveBySauvetageRepository;
import fr.cactus_industries.nuit_info_sauveteurs.database.schema.table.TSauve;
import fr.cactus_industries.nuit_info_sauveteurs.database.schema.table.TSauveBySauvetage;
import fr.cactus_industries.nuit_info_sauveteurs.database.schema.table.TSauvetage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SauveBySauvetageServiceImpl implements SauveBySauvetageService{
    
    @Autowired
    private SauveBySauvetageRepository repo;
    
    @Override
    public TSauveBySauvetage save(TSauveBySauvetage s) {
        return repo.save(s);
    }
    
    @Override
    public List<TSauveBySauvetage> findAll() {
        return repo.findAll();
    }
    
    @Override
    public List<TSauveBySauvetage> findAllBySauvetage(TSauvetage sauvetage) {
        return repo.getSauveOfSauvetage(sauvetage);
    }
    
    @Override
    public List<TSauveBySauvetage> findAllBySauve(TSauve sauve) {
        return repo.getSauvetageOfSauve(sauve);
    }
}
