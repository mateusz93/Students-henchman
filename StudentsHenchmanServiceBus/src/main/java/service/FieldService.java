package service;

import cdm.FieldRS;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author Mateusz Wieczorek on 10/12/16.
 */
public interface FieldService {

    FieldRS prepareResultForGetFieldByName(HttpServletResponse httpResponse, String name);
    FieldRS prepareResultForGetFieldById(HttpServletResponse httpResponse, String id);
    FieldRS prepareResultForGetFields(HttpServletResponse httpResponse);
    FieldRS prepareResultForGetFieldByDepartmentId(HttpServletResponse httpResponse, String departmentId);

}
