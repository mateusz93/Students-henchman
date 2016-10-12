package repository;

import model.Department;
import model.Field;

import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/12/16.
 */
public interface FieldRepository extends CrudRepository<Field, Long> {

    List<Field> findByName(String name);
    List<Field> findByDepartment(Department department);
    Field findById(Long id);
}
