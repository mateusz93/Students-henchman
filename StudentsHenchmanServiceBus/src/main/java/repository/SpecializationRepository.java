package repository;

import model.Field;
import model.Specialization;

import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/12/16.
 */
public interface SpecializationRepository extends CrudRepository<Specialization, Long> {

    List<Specialization> findByName(String name);
    Specialization findById(Long id);
    List<Specialization> findByField(Field field);
}
