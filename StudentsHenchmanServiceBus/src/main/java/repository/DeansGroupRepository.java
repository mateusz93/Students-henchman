package repository;

import model.DeansGroup;

/**
 * @Author Mateusz Wieczorek on 10/12/16.
 */
public interface DeansGroupRepository extends CrudRepository<DeansGroup, Long> {

    DeansGroup findByName(String name);
    DeansGroup findById(Long id);

}
