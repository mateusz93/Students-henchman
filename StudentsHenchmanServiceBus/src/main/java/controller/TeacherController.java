package controller;

import cdm.TeacherRS;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import repository.TeacherRepository;
import service.TeacherService;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author Mateusz Wieczorek on 10/12/16.
 */
@RestController
@RequestMapping("/mobile/teachers")
public class TeacherController {

    private static final Logger log = LoggerFactory.getLogger(TeacherController.class);

    @Autowired
    private TeacherRepository repository;

    @Autowired
    private TeacherService teacherService;

    @RequestMapping(method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public TeacherRS getTeacher(@RequestParam(value="lastName", required=false) String lastName,
                                @RequestParam(value="firstName", required=false) String firstName,
                                @RequestParam(value="email", required=false) String email,
                                @RequestParam(value="id", required=false) String id,
                                HttpServletResponse httpResponse) {
        log.info("getTeacher core invoked.");
        if (StringUtils.isNotEmpty(lastName)) {
            log.info("PathParameter: lastName=" + lastName);
            return teacherService.prepareResultForGetTeacherByLastName(httpResponse, lastName);
        } else if (StringUtils.isNotEmpty(firstName)) {
            log.info("PathParameter: firstName=" + firstName);
            return teacherService.prepareResultForGetTeacherByFirstName(httpResponse, firstName);
        } else if (StringUtils.isNotEmpty(id)) {
            log.info("PathParameter: id=" + id);
            return teacherService.prepareResultForGetTeacherById(httpResponse, id);
        } else if (StringUtils.isNotEmpty(email)) {
            log.info("PathParameter: email=" + email);
            return teacherService.prepareResultForGetTeacherByEmail(httpResponse, email);
        }
        return teacherService.prepareResultForGetTeachers(httpResponse);
    }

}
