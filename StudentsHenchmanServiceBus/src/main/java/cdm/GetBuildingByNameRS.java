package cdm;

import model.Building;

/**
 * @Author Mateusz Wieczorek on 10/8/16.
 */
public class GetBuildingByNameRS {

    private Building building;
    private String status;

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GetBuildingByNameRS{" +
                "building=" + building +
                ", status=" + status +
                '}';
    }
}
