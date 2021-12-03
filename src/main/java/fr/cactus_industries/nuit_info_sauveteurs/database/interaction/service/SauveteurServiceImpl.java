package fr.cactus_industries.nuit_info_sauveteurs.database.interaction.service;

import fr.cactus_industries.nuit_info_sauveteurs.database.interaction.repository.SauveteurRepository;
import fr.cactus_industries.nuit_info_sauveteurs.database.schema.table.TSauveteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SauveteurServiceImpl implements SauveteurService {
    
    @Autowired
    private SauveteurRepository repo;
    
    @Override
    public TSauveteur save(TSauveteur s) {
        return repo.save(s);
    }
    
    @Override
    public List<TSauveteur> findAll() {
        return repo.findAll();
    }
    
    @Override
    public List<TSauveteur> findAllById(List<Long> sauveteurs) {
        return repo.findAllById(sauveteurs);
    }
    
    @Override
    public Optional<TSauveteur> findById(long id) {
        return repo.findById(id);
    }
    
    @Override
    public List<TSauveteur> searchByName(String value) {
        return repo.searchSauveteurByNameIgnoreCase(value);
    }
}
