package firstApp.service;

import firstApp.entity.Foyer;
import firstApp.entity.Universite;
import firstApp.repository.IFoyerRepository;
import firstApp.repository.IUniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UniversiteService implements IUniversiteService {
    @Autowired
    IUniversiteRepository universiteRepository;
    @Autowired
    IFoyerRepository foyerRepository;
    @Override
    public List<Universite> retrieveAllUniversities() {
        return List.of();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {

        return universiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(long idUniversite) {
        return universiteRepository.findById((int) idUniversite).orElse(null);





}

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {


        Foyer foyer = foyerRepository.findById((int) idFoyer).orElse(null);
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);

        if (foyer == null || universite == null) {
            throw new RuntimeException("Foyer ou Université introuvable !");

        }
        

        return universiteRepository.save(universite);
    }
    }
