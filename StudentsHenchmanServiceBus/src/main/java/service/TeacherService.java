package service;

import cdm.TeacherRS;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author Mateusz Wieczorek on 10/12/16.
 */
public interface TeacherService {

    TeacherRS prepareResultForGetTeacherByName(HttpServletResponse httpResponse, String name);
    TeacherRS prepareResultForGetTeacherById(HttpServletResponse httpResponse, String id);
    TeacherRS prepareResultForGetTeachers(HttpServletResponse httpResponse);
    TeacherRS prepareResultForGetTeacherByEmail(HttpServletResponse httpResponse, String email);

}
