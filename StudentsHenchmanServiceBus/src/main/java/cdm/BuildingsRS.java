package cdm;

import model.Building;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/9/16.
 */
public class BuildingsRS {

    private List<Building> buildings = new ArrayList<>();

    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }

    @Override
    public String toString() {
        return "BuildingsRS{" +
                "buildings=" + buildings +
                '}';
    }
}
