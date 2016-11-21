package repository;

import model.Course;
import model.DeanGroup;

import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/12/16.
 */
public interface CourseRepository extends CrudRepository<Course, Long> {

    List<Course> findByName(String name);
    Course findById(Long id);
    List<Course> findByDeanGroup(DeanGroup deanGroup);
}
