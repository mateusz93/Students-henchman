package cdm;

import model.DeansGroup;

import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/12/16.
 */
public class DeansGroupRS {

    private List<DeansGroup> deansGroups;

    public List<DeansGroup> getDeansGroups() {
        return deansGroups;
    }

    public void setDeansGroups(List<DeansGroup> deansGroups) {
        this.deansGroups = deansGroups;
    }

    @Override
    public String toString() {
        return "DeansGroupRS{" +
                "deansGroups=" + deansGroups +
                '}';
    }
}
