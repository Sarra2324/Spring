package firstApp.service;

import firstApp.entity.Bloc;
import firstApp.entity.Chambre;
import firstApp.repository.IBlocRepository;
import firstApp.repository.IChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BlocService implements IBlocService{
    @Autowired
    IBlocRepository blocRepository;
    @Autowired
    IChambreRepository chambreRepository;
    @Override
    public List<Bloc> retrieveBlocs() {
        return List.of();

    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return blocRepository.findById((int) idBloc).get();
    }

    @Override
    public void removeBloc(long idBloc) {
         blocRepository.deleteById((int) idBloc) ;

    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        Bloc bloc = blocRepository.findById((int)idBloc).orElse(null);

        List<Chambre> chambres = chambreRepository.findByNumeroChambreIn(numChambre);

        if (chambres.isEmpty()) {
            throw new RuntimeException("Aucune chambre trouvée avec les numéros fournis.");
        }

        for (Chambre chambre : chambres) {
            chambre.setBloc(bloc);
        }

        chambreRepository.saveAll(chambres);

        Set<Chambre> updatedChambres = chambres.stream().collect(Collectors.toSet());
        bloc.setChambres(updatedChambres);

        return blocRepository.save(bloc);
    }
    }
