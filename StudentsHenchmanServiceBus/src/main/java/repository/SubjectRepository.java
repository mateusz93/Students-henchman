package repository;

import model.Subject;

import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/12/16.
 */
public interface SubjectRepository extends CrudRepository<Subject, Long> {

    List<Subject> findByName(String name);
    Subject findById(Long id);
    Subject findByCode(String code);

}