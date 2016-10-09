package cdm;

import model.Building;

import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/8/16.
 */
public class GetBuildingByDepartmentRS {

    private List<Building> buildings;
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
        return "GetBuildingByDepartmentRS{" +
                "buildings=" + buildings +
                ", status='" + status + '\'' +
                '}';
    }
}
