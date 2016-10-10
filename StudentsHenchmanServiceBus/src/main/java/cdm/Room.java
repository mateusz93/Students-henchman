package cdm;

import java.io.Serializable;

/**
 * @Author Mateusz Wieczorek on 10/6/16.
 */
public class Room implements Serializable {

    private int id;
    private String name;
    private Building building;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", building=" + building +
                '}';
    }
}
