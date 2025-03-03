package firstApp.controller;

import firstApp.entity.Bloc;
import firstApp.service.BlocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blocs")
public class BlocController {

    @Autowired
    private BlocService blocService;

    @GetMapping("/getAll")
    public List<Bloc> retrieveBlocs() {
        return blocService.retrieveBlocs();
    }

    @PostMapping("/add")
    public Bloc addBloc(@RequestBody Bloc bloc) {
        return blocService.addBloc(bloc);
    }

    @PutMapping("/update")
    public Bloc updateBloc(@RequestBody Bloc bloc) {
        return blocService.updateBloc(bloc);
    }

    @GetMapping("/get/{id}")
    public Bloc retrieveBloc(@PathVariable("id") long idBloc) {
        return blocService.retrieveBloc(idBloc);
    }

    @DeleteMapping("/delete/{id}")
    public void removeBloc(@PathVariable("id") long idBloc) {
        blocService.removeBloc(idBloc);
    }
}
