package repository;

import model.DeanGroup;
import model.DependentDeanGroup;
import org.springframework.stereotype.Repository;

/**
 * Created by Michał on 2016-11-24.
 */
@Repository
public interface DependentDeanGroupRepository extends CrudRepository<DependentDeanGroup, Long> {

    DependentDeanGroup findByDependentDeanGroupId(DeanGroup deanGroup);
}
