package repository;

import model.Field;

/**
 * @Author Mateusz Wieczorek on 10/12/16.
 */
public interface FieldRepository extends CrudRepository<Field, Long> {

    Field findByName(String name);
    Field findById(Long id);
}
