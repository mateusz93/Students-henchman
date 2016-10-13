package cdm;

import model.Room;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/13/16.
 */
public class RoomRS {

    private List<Room> rooms = new ArrayList<>();

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "RoomRS{" +
                "rooms=" + rooms +
                '}';
    }
}
