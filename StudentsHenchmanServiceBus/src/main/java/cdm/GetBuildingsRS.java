package cdm;

import model.Building;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/9/16.
 */
public class GetBuildingsRS {

    private List<Building> buildings = new ArrayList<>();
    private String status;

    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GetBuildingsRS{" +
                "buildings=" + buildings +
                ", status='" + status + '\'' +
                '}';
    }
}
