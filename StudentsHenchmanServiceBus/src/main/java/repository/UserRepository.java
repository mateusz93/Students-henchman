package repository;

import model.User;

/**
 * @Author Mateusz Wieczorek on 20.11.2016.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);
}
