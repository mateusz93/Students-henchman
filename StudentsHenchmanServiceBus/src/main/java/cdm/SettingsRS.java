package cdm;

import model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/20/16.
 */
public class SettingsRS {

    private List<Field> fields = new ArrayList<>();
    private List<Department> departments = new ArrayList<>();
    private List<DeanGroup> deanGroups = new ArrayList<>();

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<DeanGroup> getDeanGroups() {
        return deanGroups;
    }

    public void setDeanGroups(List<DeanGroup> deanGroups) {
        this.deanGroups = deanGroups;
    }
}
