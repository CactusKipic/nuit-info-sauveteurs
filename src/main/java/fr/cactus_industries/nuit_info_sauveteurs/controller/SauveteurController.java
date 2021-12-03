package fr.cactus_industries.nuit_info_sauveteurs.controller;

import fr.cactus_industries.nuit_info_sauveteurs.database.interaction.service.SauvetageService;
import fr.cactus_industries.nuit_info_sauveteurs.database.interaction.service.SauveteurBySauvetageService;
import fr.cactus_industries.nuit_info_sauveteurs.database.interaction.service.SauveteurService;
import fr.cactus_industries.nuit_info_sauveteurs.database.schema.table.*;
import fr.cactus_industries.nuit_info_sauveteurs.outils.RepositoriesService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class SauveteurController {
    
    private final SauveteurService service;
    private final SauveteurBySauvetageService sauveteurBySauvetageService;
    private final SauvetageService sauvetageService;
    
    public SauveteurController(RepositoriesService repoService){
        this.service = repoService.getSauveteurService();
        this.sauveteurBySauvetageService = repoService.getSauveteurBySauvetageService();
        this.sauvetageService = repoService.getSauvetageService();
    }
    
    @GetMapping("/sauveteur/getall")
    public List<TSauveteur> getAllSauve(){
        return service.findAll();
    }
    
    @GetMapping("/sauveteur/search")
    public List<TSauveteur> searchByName(@RequestParam("name") Optional<String> value){
        if(value.isPresent())
            return service.searchByName(value.get());
        else
            return new ArrayList<>();
    }
    
    @GetMapping("/sauveteur/get")
    public TSauveteur getSauveteur(@RequestParam("idsauveteur")Long id) {
        return this.service.findById(id).orElse(null);
    }
    
    @GetMapping("/sauveteur/sauvetage")
    public List<TSauvetage> getSauvetageOfSauveteur(@RequestParam("idsauveteur")Long id) {
        Optional<TSauveteur> byId = this.service.findById(id);
        return byId.map(tSauveteur -> this.sauveteurBySauvetageService.findAllBySauveteur(tSauveteur)
                .stream().map(s -> this.sauvetageService.findById(s.getIdSauvetage()).get())
                        .collect(Collectors.toList()))
                .orElseGet(ArrayList::new);
    }
    
    @GetMapping("/sauveteur/addsauvetage")
    public TSauveteurBySauvetage addSauveToSauvetage(@RequestParam("idsauveteur")Long idsauveteur, @RequestParam("idsauvetage")Long idSauvetage) {
        Optional<TSauveteur> sauveteurById = this.service.findById(idsauveteur);
        if(sauveteurById.isPresent()) {
            Optional<TSauvetage> sauvetageById = this.sauvetageService.findById(idSauvetage);
            if(sauvetageById.isPresent()) {
                return this.sauveteurBySauvetageService.save(new TSauveteurBySauvetage(idSauvetage, idsauveteur));
            }
        }
        return null;
    }
    
    @PostMapping("/sauveteur/save")
    public TSauveteur saveSauvetage(@RequestParam("adminkey")Optional<String> key,
                                    @RequestBody()TSauveteur sauveteur){
        Optional<TSauveteur> byId = this.service.findById(sauveteur.getId());
        if(byId.isEmpty()) {
            if(sauveteur.isValide()) {
                if(key.isPresent() && key.get().equals("NuitInfo")) {
                    return this.service.save(sauveteur);
                } else
                    return null;
            } else
                return this.service.save(sauveteur);
        }
        if(byId.get().isValide()) {
            if(key.isPresent() && key.get().equals("NuitInfo")){
                return this.service.save(sauveteur);
            } else {
                return null;
            }
        }
        if(sauveteur.isValide()) {
            if(key.isPresent() && key.get().equals("NuitInfo")) {
                return this.service.save(sauveteur);
            } else
                return null;
        } else
            return this.service.save(sauveteur);
    }
}
