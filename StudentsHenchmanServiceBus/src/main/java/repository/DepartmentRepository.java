package repository;

import model.Department;

/**
 * @Author Mateusz Wieczorek on 10/4/16.
 */
public interface DepartmentRepository extends CrudRepository<Department, Long> {

    Department findByName(String name);
}
