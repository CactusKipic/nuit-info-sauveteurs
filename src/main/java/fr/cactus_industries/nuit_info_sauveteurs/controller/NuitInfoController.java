package fr.cactus_industries.nuit_info_sauveteurs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NuitInfoController {
    
    @GetMapping("/up")
    public String isUp() {
        return "Yes, it is.";
    }
}
