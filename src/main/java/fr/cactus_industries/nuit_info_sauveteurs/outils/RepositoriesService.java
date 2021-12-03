package fr.cactus_industries.nuit_info_sauveteurs.outils;

import fr.cactus_industries.nuit_info_sauveteurs.database.interaction.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoriesService {
    
    private final SauveService sauveService;
    private final SauvetageService sauvetageService;
    private final SauveteurService sauveteurService;
    private final SauveBySauvetageService sauveBySauvetageService;
    private final SauveteurBySauvetageService sauveteurBySauvetageService;
    
    public RepositoriesService(ApplicationContext ctx) {
        this.sauveService = ctx.getBean(SauveService.class);
        this.sauvetageService = ctx.getBean(SauvetageService.class);
        this.sauveteurService = ctx.getBean(SauveteurService.class);
        this.sauveBySauvetageService = ctx.getBean(SauveBySauvetageService.class);
        this.sauveteurBySauvetageService = ctx.getBean(SauveteurBySauvetageService.class);
    }
    
    public SauveService getSauveService() {
        return sauveService;
    }
    
    public SauvetageService getSauvetageService() {
        return sauvetageService;
    }
    
    public SauveteurService getSauveteurService() {
        return sauveteurService;
    }
    
    public SauveBySauvetageService getSauveBySauvetageService() {
        return sauveBySauvetageService;
    }
    
    public SauveteurBySauvetageService getSauveteurBySauvetageService() {
        return sauveteurBySauvetageService;
    }
}
