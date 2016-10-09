package cdm;

import model.Department;

/**
 * @Author Mateusz Wieczorek on 10/8/16.
 */
public class GetBuildingByDepartmentRQ {

    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "GetBuildingByDepartmentRQ{" +
                "department=" + department +
                '}';
    }
}
