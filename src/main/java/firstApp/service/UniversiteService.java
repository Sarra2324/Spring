package firstApp.service;

import firstApp.entity.Bloc;
import firstApp.entity.Foyer;
import firstApp.entity.Universite;
import firstApp.repository.IBlocRepository;
import firstApp.repository.IFoyerRepository;
import firstApp.repository.IUniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UniversiteService implements IUniversiteService {
    @Autowired
    IUniversiteRepository universiteRepository;
    @Autowired
    IFoyerRepository foyerRepository;
    @Autowired
    IBlocRepository blocRepository;

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
        Foyer foyer = foyerRepository.findById((int) idFoyer).get();
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);

        if (foyer == null || universite == null) {
            throw new RuntimeException("Foyer ou Université introuvable !");
        }
        universite.setFoyer(foyer);


        return universiteRepository.save(universite);
    }

    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        return null;
    }

    @Override
    public Universite ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Universite universite = universiteRepository.findById((int) idUniversite).orElse(null);
        Foyer savedFoyer = foyerRepository.save(foyer);

        universite.setFoyer(savedFoyer);
        universiteRepository.save(universite);
        Set<Bloc> blocs = foyer.getBlocs();
        if (blocs != null) {
            for (Bloc bloc : blocs) {
                bloc.setFoyer(savedFoyer);
                blocRepository.save(bloc);
            }
        }

        savedFoyer.setBlocs(blocs);
        foyerRepository.save(savedFoyer);

        return universite;

    }
}
