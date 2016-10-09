package cdm;

import model.Department;

/**
 * @Author Mateusz Wieczorek on 10/9/16.
 */
public class GetDepartmentByNameRS {

    private Department department;
    private String status;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GetDepartmentByNameRS{" +
                "department=" + department +
                ", status='" + status + '\'' +
                '}';
    }
}
