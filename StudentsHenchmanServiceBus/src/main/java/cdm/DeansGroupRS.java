package cdm;

import model.DeanGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/12/16.
 */
public class DeansGroupRS {

    private List<DeanGroup> deansGroups = new ArrayList<>();

    public List<DeanGroup> getDeansGroups() {
        return deansGroups;
    }

    public void setDeansGroups(List<DeanGroup> deansGroups) {
        this.deansGroups = deansGroups;
    }

    @Override
    public String toString() {
        return "DeansGroupRS{" +
                "deansGroups=" + deansGroups +
                '}';
    }
}
