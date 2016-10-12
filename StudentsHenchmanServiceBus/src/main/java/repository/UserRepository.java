package repository;

import model.User;

/**
 * @Author Mateusz Wieczorek on 10/10/16.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findById(Long id);
    User findByFirstName(String firstName);
    User findByLastName(String lastName);
    User findByEmail(String email);

}
