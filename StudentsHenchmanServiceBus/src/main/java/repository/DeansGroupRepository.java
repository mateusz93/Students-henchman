package repository;

import model.DeanGroup;

/**
 * @Author Mateusz Wieczorek on 10/12/16.
 */
public interface DeansGroupRepository extends CrudRepository<DeanGroup, Long> {

    DeanGroup findByName(String name);
    DeanGroup findById(Long id);

}
