package repository;

import model.Build;

/**
 * @Author Mateusz Wieczorek on 10/8/16.
 */
public interface BuildingRepository extends CrudRepository<Build, Long> {

    Build findByCode(String code);
    Build findById(Long id);
}
