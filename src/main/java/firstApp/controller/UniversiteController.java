package firstApp.controller;

import firstApp.entity.Foyer;
import firstApp.entity.Universite;
import firstApp.service.UniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/universites")
public class UniversiteController {

    @Autowired
    private UniversiteService universiteService;

    @GetMapping("/getAll")
    public List<Universite> retrieveAllUniversities() {
        return universiteService.retrieveAllUniversities();
    }

    @PostMapping("/add")
    public Universite addUniversite(@RequestBody Universite u) {
        return universiteService.addUniversite(u);
    }

    @PutMapping("/update")
    public Universite updateUniversite(@RequestBody Universite u) {
        return universiteService.updateUniversite(u);
    }

    @GetMapping("/get/{id}")
    public Universite retrieveUniversite(@PathVariable("id") long idUniversite) {
        return universiteService.retrieveUniversite(idUniversite);
    }
    @PutMapping("/affecter-foyer/{idFoyer}/{nomUniversite}")
    public Universite affecterFoyerAUniversite(@PathVariable long idFoyer, @PathVariable String nomUniversite) {
        return universiteService.affecterFoyerAUniversite(idFoyer, nomUniversite);
    }



    @PutMapping("/desaffecter-foyer/{idUniversite}")
    public Universite desaffecterFoyerAUniversite(@PathVariable long idUniversite) {
        return universiteService.desaffecterFoyerAUniversite(idUniversite);
    }

    @PostMapping("/ajouter-foyer/{idUniversite}")
    public Universite ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer, @PathVariable long idUniversite) {
        return universiteService.ajouterFoyerEtAffecterAUniversite(foyer, idUniversite);
    }
}
