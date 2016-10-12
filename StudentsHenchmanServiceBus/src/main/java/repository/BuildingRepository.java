package repository;

import model.Building;

/**
 * @Author Mateusz Wieczorek on 10/8/16.
 */
public interface BuildingRepository extends CrudRepository<Building, Long> {

    Building findByName(String name);
    Building findById(Long id);
}
