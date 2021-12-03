package fr.cactus_industries.nuit_info_sauveteurs;

import fr.cactus_industries.nuit_info_sauveteurs.outils.RepositoriesService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Launcher {
    
    public static RepositoriesService repositoriesService;
    
    public static void main(String[] args) {
        ConfigurableApplicationContext configCtx = SpringApplication.run(Launcher.class, args);
        
        repositoriesService = configCtx.getBean(RepositoriesService.class);
        System.out.println("Nuit de l'info lancé !");
    }
    
}
