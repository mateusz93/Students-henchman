package service;

import cdm.DepartmentsRS;

/**
 * @Author Mateusz Wieczorek on 10/9/16.
 */
public interface DepartmentService {

    DepartmentsRS prepareResultForGetDepartments();
    DepartmentsRS prepareResultForGetDepartmentByName(String name);
    DepartmentsRS prepareResultForGetDepartmentById(String id);

}
