package fr.cactus_industries.nuit_info_sauveteurs.controller;

import fr.cactus_industries.nuit_info_sauveteurs.database.interaction.service.*;
import fr.cactus_industries.nuit_info_sauveteurs.database.schema.table.TSauve;
import fr.cactus_industries.nuit_info_sauveteurs.database.schema.table.TSauvetage;
import fr.cactus_industries.nuit_info_sauveteurs.database.schema.table.TSauveteur;
import fr.cactus_industries.nuit_info_sauveteurs.outils.RepositoriesService;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class SauvetageController {
    
    private final SauvetageService service;
    private final SauveBySauvetageService sauveBySauvetageService;
    private final SauveteurBySauvetageService sauveteurBySauvetageService;
    private final SauveService sauveService;
    private final SauveteurService sauveteurService;
    
    public SauvetageController(RepositoriesService repoService){
        this.service = repoService.getSauvetageService();
        this.sauveBySauvetageService = repoService.getSauveBySauvetageService();
        this.sauveteurBySauvetageService = repoService.getSauveteurBySauvetageService();
        this.sauveService = repoService.getSauveService();
        this.sauveteurService = repoService.getSauveteurService();
    }
    
    @GetMapping("/sauvetage/getall")
    public List<TSauvetage> getAllSauve(){
        return service.findAll();
    }
    
    @GetMapping("/sauvetage/search")
    public List<TSauvetage> searchByName(@RequestParam("name")Optional<String> value,
                                         @RequestParam("startdate") Optional<Date> start, @RequestParam("enddate")Optional<Date> end){
        if(value.isEmpty()) {
            if(start.isPresent() && end.isPresent()) {
                return service.searchBetweenDate(start.get(), end.get());
            } else
                return new ArrayList<>();
        } else {
            if(start.isPresent() && end.isPresent()) {
                return service.searchBetweenDateAndName(start.get(), end.get(), value.get());
            } else
                return service.searchByName(value.get());
        }
    }
    
    @GetMapping("/sauvetage/get")
    public TSauvetage getSauvetage(@RequestParam("idsauvetage")long id){
        return this.service.findById(id).orElse(null);
    }
    
    @GetMapping("/sauvetage/getsauve")
    public List<TSauve> getSauve(@RequestParam("idsauvetage")Long id){
        Optional<TSauvetage> sauvetage = service.findById(id);
        return sauvetage.map(tSauvetage -> this.sauveBySauvetageService.findAllBySauvetage(tSauvetage)
                .stream().map(s -> this.sauveService.findById(s.getIdSauve()).get())
                        .collect(Collectors.toList()))
                .orElseGet(ArrayList::new);
    }
    
    @GetMapping("/sauvetage/getsauveteur")
    public List<TSauveteur> getSauveteur(@RequestParam("idsauvetage")Long id){
        Optional<TSauvetage> sauvetage = service.findById(id);
        return sauvetage.map(tSauvetage -> this.sauveteurBySauvetageService.findAllBySauvetage(tSauvetage)
                .stream().map(s -> this.sauveteurService.findById(s.getIdSauveteur()).get())
                        .collect(Collectors.toList()))
                .orElseGet(ArrayList::new);
    }
    
    @PostMapping("/sauvetage/save")
    public TSauvetage saveSauvetage(@RequestParam("adminkey")Optional<String> key,
            @RequestBody()TSauvetage sauvetage){
        Optional<TSauvetage> byId = this.service.findById(sauvetage.getId());
        if(byId.isEmpty()) {
            if(sauvetage.isValide()) {
                if(key.isPresent() && key.get().equals("NuitInfo")) {
                    return this.service.save(sauvetage);
                } else
                    return null;
            } else
                return this.service.save(sauvetage);
        }
        if(byId.get().isValide()) {
            if(key.isPresent() && key.get().equals("NuitInfo")){
                return this.service.save(sauvetage);
            } else {
                return null;
            }
        }
        if(sauvetage.isValide()) {
            if(key.isPresent() && key.get().equals("NuitInfo")) {
                return this.service.save(sauvetage);
            } else
                return null;
        } else
            return this.service.save(sauvetage);
    }
}
