package repository;

import model.Field;
import model.SubjectsBlock;

import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/13/16.
 */
public interface SubjectsBlockRepository extends CrudRepository<SubjectsBlock, Long> {

    List<SubjectsBlock> findByName(String name);
    SubjectsBlock findById(Long id);
    List<SubjectsBlock> findByField(Field field);
}
