package service;

import cdm.GetDepartmentByNameRS;
import cdm.GetDepartmentsRS;

/**
 * @Author Mateusz Wieczorek on 10/9/16.
 */
public interface DepartmentService {

    GetDepartmentsRS prepareResultForGetDepartments();
    GetDepartmentByNameRS prepareResultForGetDepartmentByName(String request);

}
