package service;

import cdm.TeacherRS;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author Mateusz Wieczorek on 10/12/16.
 */
public interface TeacherService {

    TeacherRS prepareResultForGetTeacherByLastName(HttpServletResponse httpResponse, String lastName);
    TeacherRS prepareResultForGetTeacherByFirstName(HttpServletResponse httpResponse, String firstName);
    TeacherRS prepareResultForGetTeacherById(HttpServletResponse httpResponse, String id);
    TeacherRS prepareResultForGetTeachers(HttpServletResponse httpResponse);
    TeacherRS prepareResultForGetTeacherByEmail(HttpServletResponse httpResponse, String email);

}
