package repository;

import model.User;

import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/10/16.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findById(Long id);
    List<User> findByFirstName(String firstName);
    List<User> findByLastName(String lastName);
    User findByEmail(String email);

}
