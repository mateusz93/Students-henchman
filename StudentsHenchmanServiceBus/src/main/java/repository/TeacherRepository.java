package repository;

import model.Teacher;

import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/12/16.
 */
public interface TeacherRepository extends CrudRepository<Teacher, Long> {

    Teacher findById(Long id);
    List<Teacher> findByName(String name);
    Teacher findByEmail(String email);

}
