package firstApp.controller;

import firstApp.entity.Chambre;
import firstApp.service.ChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chambres")
public class ChambreController {

    @Autowired
    private ChambreService chambreService;

    @GetMapping("/getAll")
    public List<Chambre> retrieveAllChambres() {
        return chambreService.retrieveAllChambres();
    }

    @PostMapping("/add")
    public Chambre addChambre(@RequestBody Chambre c) {
        return chambreService.addChambre(c);
    }

    @PutMapping("/update")
    public Chambre updateChambre(@RequestBody Chambre c) {
        return chambreService.updateChambre(c);
    }

    @GetMapping("/get/{id}")
    public Chambre retrieveChambre(@PathVariable("id") long idChambre) {
        return chambreService.retrieveChambre(idChambre);
    }


}
