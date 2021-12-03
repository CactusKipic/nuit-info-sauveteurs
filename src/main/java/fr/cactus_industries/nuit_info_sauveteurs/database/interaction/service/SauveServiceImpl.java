package fr.cactus_industries.nuit_info_sauveteurs.database.interaction.service;

import fr.cactus_industries.nuit_info_sauveteurs.database.interaction.repository.SauveRepository;
import fr.cactus_industries.nuit_info_sauveteurs.database.schema.table.TSauve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SauveServiceImpl implements SauveService{
    
    @Autowired
    private SauveRepository repo;
    
    @Override
    public TSauve save(TSauve s) {
        return repo.save(s);
    }
    
    @Override
    public List<TSauve> findAll() {
        return repo.findAll();
    }
    
    @Override
    public List<TSauve> findAllById(List<Long> sauves) {
        return repo.findAllById(sauves);
    }
    
    @Override
    public Optional<TSauve> findById(long id) {
        return repo.findById(id);
    }
    
    @Override
    public List<TSauve> searchByName(String value) {
        return repo.searchSauveByNameIgnoreCase(value);
    }
}
