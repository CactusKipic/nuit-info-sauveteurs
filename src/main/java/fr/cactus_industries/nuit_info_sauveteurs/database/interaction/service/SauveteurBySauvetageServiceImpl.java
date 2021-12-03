package fr.cactus_industries.nuit_info_sauveteurs.database.interaction.service;

import fr.cactus_industries.nuit_info_sauveteurs.database.interaction.repository.SauveteurBySauvetageRepository;
import fr.cactus_industries.nuit_info_sauveteurs.database.schema.table.TSauvetage;
import fr.cactus_industries.nuit_info_sauveteurs.database.schema.table.TSauveteur;
import fr.cactus_industries.nuit_info_sauveteurs.database.schema.table.TSauveteurBySauvetage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SauveteurBySauvetageServiceImpl implements SauveteurBySauvetageService{
    
    @Autowired
    private SauveteurBySauvetageRepository repo;
    
    @Override
    public TSauveteurBySauvetage save(TSauveteurBySauvetage s) {
        return repo.save(s);
    }
    
    @Override
    public List<TSauveteurBySauvetage> findAll() {
        return repo.findAll();
    }
    
    @Override
    public List<TSauveteurBySauvetage> findAllBySauvetage(TSauvetage sauvetage) {
        return repo.getSauveteurOfSauvetage(sauvetage);
    }
    
    @Override
    public List<TSauveteurBySauvetage> findAllBySauveteur(TSauveteur sauveteur) {
        return repo.getSauvetageOfSauve(sauveteur);
    }
}
