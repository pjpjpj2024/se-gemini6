package th.ac.mahidol.ict.gemini6.Repository;

import org.springframework.data.repository.CrudRepository;
import th.ac.mahidol.ict.gemini6.Model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
