package service;

import cdm.CourseTypeRS;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author Mateusz Wieczorek on 10/13/16.
 */
public interface CourseTypeService {

    CourseTypeRS prepareResultForGetCourseTypeByType(HttpServletResponse httpResponse, String type);
    CourseTypeRS prepareResultForGetCourseTypeById(HttpServletResponse httpResponse, String id);
    CourseTypeRS prepareResultForGetCourseTypes(HttpServletResponse httpResponse);

}
