package cdm;

import model.Department;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/9/16.
 */
public class DepartmentsRS {

    private List<Department> departments = new ArrayList<>();
    private String status;

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DepartmentsRS{" +
                "departments=" + departments +
                ", status='" + status + '\'' +
                '}';
    }
}
