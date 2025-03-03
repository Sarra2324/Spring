package firstApp.controller;

import firstApp.entity.Foyer;
import firstApp.service.IFoyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FoyerController  {
    @Autowired
    IFoyerService foyerService;

    @GetMapping("/getAllFoyer")
    public List<Foyer> retrieveAllFoyers() {
        return foyerService.retrieveAllFoyers();
    }

    @PostMapping("/addFoyer")
    public Foyer addFoyer(Foyer f) {
        return foyerService.addFoyer(f);
    }


    @PutMapping("/updateFoyer/{id}")
    public Foyer updateFoyer(Foyer f) {
        return foyerService.updateFoyer(f);
    }

    @GetMapping("/getFoyer/{id}")
    public Foyer retrieveFoyer(@PathVariable("id") long idFoyer) {
        return foyerService.retrieveFoyer(idFoyer);
    }

    @DeleteMapping("deleteFoyer/{id}")
    public void removeFoyer(@PathVariable("id") long idFoyer) {
        foyerService.removeFoyer(idFoyer);
    }

}