package repository;

import model.Building;
import model.Department;

import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/8/16.
 */
public interface BuildingRepository extends CrudRepository<Building, Long> {

    Building findByName(String name);
    List<Building> findByDepartment(Department department);
}
