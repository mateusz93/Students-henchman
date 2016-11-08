package cdm;

import model.Build;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/9/16.
 */
public class BuildingsRS {

    private List<Build> buildings = new ArrayList<>();

    public List<Build> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Build> buildings) {
        this.buildings = buildings;
    }

    @Override
    public String toString() {
        return "BuildingsRS{" +
                "buildings=" + buildings +
                '}';
    }
}
