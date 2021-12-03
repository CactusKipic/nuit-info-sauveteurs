package fr.cactus_industries.nuit_info_sauveteurs.database.interaction.service;

import fr.cactus_industries.nuit_info_sauveteurs.database.interaction.repository.SauvetageRepository;
import fr.cactus_industries.nuit_info_sauveteurs.database.schema.table.TSauvetage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SauvetageServiceImpl implements SauvetageService {
    
    @Autowired
    private SauvetageRepository repo;
    
    @Override
    public TSauvetage save(TSauvetage s) {
        return repo.save(s);
    }
    
    @Override
    public List<TSauvetage> findAll() {
        return repo.findAll();
    }
    
    @Override
    public List<TSauvetage> findAllById(List<Long> sauvetages) {
        return repo.findAllById(sauvetages);
    }
    
    @Override
    public Optional<TSauvetage> findById(long id) {
        return repo.findById(id);
    }
    
    @Override
    public List<TSauvetage> searchByName(String value) {
        return repo.searchSauvetageByNameIgnoreCase(value);
    }
    
    @Override
    public List<TSauvetage> searchBetweenDate(Date start, Date end) {
        return repo.searchBetweenDate(start, end);
    }
    
    @Override
    public List<TSauvetage> searchBetweenDateAndName(Date start, Date end, String value) {
        return repo.searchBetweenDateAndName(start, end, value);
    }
}
