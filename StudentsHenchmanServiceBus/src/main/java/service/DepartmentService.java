package service;

import cdm.DepartmentsRS;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author Mateusz Wieczorek on 10/9/16.
 */
public interface DepartmentService {

    DepartmentsRS prepareResultForGetDepartments(HttpServletResponse httpResponse);
    DepartmentsRS prepareResultForGetDepartmentByName(HttpServletResponse httpResponse, String name);
    DepartmentsRS prepareResultForGetDepartmentById(HttpServletResponse httpResponse, String id);

}
