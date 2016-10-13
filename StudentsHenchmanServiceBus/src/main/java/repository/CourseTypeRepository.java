package repository;

import model.CourseType;

/**
 * @Author Mateusz Wieczorek on 10/13/16.
 */
public interface CourseTypeRepository extends CrudRepository<CourseType, Long> {

    CourseType findByType(String type);
    CourseType findById(Long id);

}
