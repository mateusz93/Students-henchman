package controller;

import cdm.TeacherRS;
import model.User;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import repository.TeacherRepository;
import repository.UserRepository;
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
    private UserRepository userRepository;

    @Autowired
    private TeacherRepository repository;

    @Autowired
    private TeacherService teacherService;

    @RequestMapping(method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public TeacherRS getTeacher(@RequestParam(value = "name", required = false) String name,
                                @RequestParam(value = "email", required = false) String email,
                                @RequestParam(value = "id", required = false) String id,
                                @RequestHeader("email") String emailHeader,
                                HttpServletResponse httpResponse) {
        TeacherRS response;
        User user = userRepository.findByEmail(emailHeader);
        if (null == user) {
            log.info("Unauthorized user during action download teachers");
            httpResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
            return null;
        }
        log.info("getTeacher core invoked.");
        if (StringUtils.isNotEmpty(name)) {
            response = teacherService.prepareResultForGetTeacherByName(httpResponse, name);
        } else if (StringUtils.isNotEmpty(id)) {
            response = teacherService.prepareResultForGetTeacherById(httpResponse, id);
        } else if (StringUtils.isNotEmpty(email)) {
            response = teacherService.prepareResultForGetTeacherByEmail(httpResponse, email);
        } else {
            response = teacherService.prepareResultForGetTeachers(httpResponse);
        }

        return response;
    }

}
