package firstApp.service;

import firstApp.entity.Bloc;
import firstApp.repository.IBlocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlocService implements IBlocService{
    @Autowired
    IBlocRepository iBlocRepository;
    @Override
    public List<Bloc> retrieveBlocs() {
        return List.of();

    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return iBlocRepository.save(bloc);
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return iBlocRepository.save(bloc);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return iBlocRepository.findById((int) idBloc).get();
    }

    @Override
    public void removeBloc(long idBloc) {
         iBlocRepository.deleteById((int) idBloc) ;

    }
}
