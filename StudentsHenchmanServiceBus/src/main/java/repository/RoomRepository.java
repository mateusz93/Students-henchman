package repository;

import model.Room;

import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/13/16.
 */
public interface RoomRepository extends CrudRepository<Room, Long> {

    List<Room> findByName(String name);
    Room findByCode(String code);
    Room findById(Long id);
}
