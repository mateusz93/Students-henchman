package repository;

import model.Field;

import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/12/16.
 */
public interface FieldRepository extends CrudRepository<Field, Long> {

    List<Field> findByName(String name);
    Field findById(Long id);
}
