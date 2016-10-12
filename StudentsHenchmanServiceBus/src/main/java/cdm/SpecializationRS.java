package cdm;

import model.Specialization;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/12/16.
 */
public class SpecializationRS {

    private List<Specialization> specializations = new ArrayList<>();

    public List<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(List<Specialization> specializations) {
        this.specializations = specializations;
    }

    @Override
    public String toString() {
        return "SpecializationRS{" +
                "specializations=" + specializations +
                '}';
    }
}
