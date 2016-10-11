package cdm;

import model.Department;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/9/16.
 */
public class DepartmentsRS {

    private List<Department> departments = new ArrayList<>();

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }


    @Override
    public String toString() {
        return "DepartmentsRS{" +
                "departments=" + departments +
                '}';
    }
}
