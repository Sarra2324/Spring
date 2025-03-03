package firstApp.repository;

import firstApp.entity.Bloc;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlocRepositor extends CrudRepository<Bloc, Integer> {
}
