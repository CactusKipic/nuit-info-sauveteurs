package fr.cactus_industries.nuit_info_sauveteurs.controller;

import fr.cactus_industries.nuit_info_sauveteurs.database.interaction.service.SauveBySauvetageService;
import fr.cactus_industries.nuit_info_sauveteurs.database.interaction.service.SauveService;
import fr.cactus_industries.nuit_info_sauveteurs.database.interaction.service.SauvetageService;
import fr.cactus_industries.nuit_info_sauveteurs.database.schema.table.TSauve;
import fr.cactus_industries.nuit_info_sauveteurs.database.schema.table.TSauveBySauvetage;
import fr.cactus_industries.nuit_info_sauveteurs.database.schema.table.TSauvetage;
import fr.cactus_industries.nuit_info_sauveteurs.outils.RepositoriesService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class SauveController {
    
    private final SauveService service;
    private final SauveBySauvetageService sauveBySauvetageService;
    private final SauvetageService sauvetageService;
    
    public SauveController(RepositoriesService repoService){
        this.service = repoService.getSauveService();
        this.sauveBySauvetageService = repoService.getSauveBySauvetageService();
        this.sauvetageService = repoService.getSauvetageService();
    }
    
    @GetMapping("/sauve/getall")
    public List<TSauve> getAllSauve(){
        return service.findAll();
    }
    
    @GetMapping("/sauve/search")
    public List<TSauve> searchByName(@RequestParam("name") Optional<String> value){
        if(value.isPresent())
            return service.searchByName(value.get());
        else
            return new ArrayList<>();
    }
    @GetMapping("/sauve/get")
    public TSauve getSauve(@RequestParam("idsauve")Long id) {
        return this.service.findById(id).orElse(null);
    }
    
    @GetMapping("/sauve/sauvetage")
    public List<TSauvetage> getSauvetageOfSauve(@RequestParam("idsauve")Long id) {
        Optional<TSauve> byId = this.service.findById(id);
        return byId.map(tSauve -> this.sauveBySauvetageService.findAllBySauve(tSauve)
                .stream().map(s -> this.sauvetageService.findById(s.getIdSauvetage()).get())
                        .collect(Collectors.toList()))
                .orElseGet(ArrayList::new);
    }
    
    @GetMapping("/sauve/addsauvetage")
    public TSauveBySauvetage addSauveToSauvetage(@RequestParam("idsauve")Long idsauve, @RequestParam("idsauvetage")Long idSauvetage) {
        Optional<TSauve> sauveById = this.service.findById(idsauve);
        if(sauveById.isPresent()) {
            Optional<TSauvetage> sauvetageById = this.sauvetageService.findById(idSauvetage);
            if(sauvetageById.isPresent()) {
                return this.sauveBySauvetageService.save(new TSauveBySauvetage(idSauvetage, idsauve));
            }
        }
        return null;
    }
    
    @PostMapping("/sauve/save")
    public TSauve saveSauvetage(@RequestParam("adminkey")Optional<String> key,
                                    @RequestBody()TSauve sauve){
        Optional<TSauve> byId = this.service.findById(sauve.getId());
        if(byId.isEmpty()) {
            if(sauve.isValide()) {
                if(key.isPresent() && key.get().equals("NuitInfo")) {
                    return this.service.save(sauve);
                } else
                    return null;
            } else
                return this.service.save(sauve);
        }
        if(byId.get().isValide()) {
            if(key.isPresent() && key.get().equals("NuitInfo")){
                return this.service.save(sauve);
            } else {
                return null;
            }
        }
        if(sauve.isValide()) {
            if(key.isPresent() && key.get().equals("NuitInfo")) {
                return this.service.save(sauve);
            } else
                return null;
        } else
            return this.service.save(sauve);
    }
}
