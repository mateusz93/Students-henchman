package service;

import cdm.CourseRS;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author Mateusz Wieczorek on 10/12/16.
 */
public interface CourseService {

    CourseRS prepareResultForGetCourseByName(HttpServletResponse httpResponse, String name);
    CourseRS prepareResultForGetCourseById(HttpServletResponse httpResponse, String id);
    CourseRS prepareResultForGetCourses(HttpServletResponse httpResponse);

}
