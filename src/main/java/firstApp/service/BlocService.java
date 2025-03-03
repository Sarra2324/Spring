package firstApp.service;

import firstApp.entity.Bloc;
import firstApp.repository.IBlocRepositor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlocService implements IBlocService{
    @Autowired
    IBlocRepositor iBlocRepositor;
    @Override
    public List<Bloc> retrieveBlocs() {
        return List.of();

    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return iBlocRepositor.save(bloc);
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return iBlocRepositor.save(bloc);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return iBlocRepositor.findById((int) idBloc).get();
    }

    @Override
    public void removeBloc(long idBloc) {
         iBlocRepositor.deleteById((int) idBloc) ;

    }
}
