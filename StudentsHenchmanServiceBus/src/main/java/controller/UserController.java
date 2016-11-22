package controller;

import cdm.PreferencesRQ;
import model.Department;
import model.Field;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import repository.DepartmentRepository;
import repository.FieldRepository;
import repository.UserRepository;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author Mateusz Wieczorek on 20.11.2016.
 */
@RestController
@RequestMapping("/mobile/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private FieldRepository fieldRepository;

    @RequestMapping(value = "/setPreferences", method = RequestMethod.POST, consumes = "application/json")
    public Boolean setPreferences(@RequestHeader("email") String email,
                                  @RequestBody PreferencesRQ preferencesRQ,
                                  HttpServletResponse httpResponse) {
        User user = userRepository.findByEmail(email);
        if (null == user) {
            log.info("Unauthorized user during setting user preferences");
            httpResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
            return null;
        }
        if (null == preferencesRQ || null == preferencesRQ.getDeanGroupIds()) {
            httpResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            return null;
        }
        log.info("setPreferences invoked.");
        Department department = departmentRepository.findById(preferencesRQ.getDepartmentId());
        Field field = fieldRepository.findById(preferencesRQ.getFieldId());
        user.setDepartment(department);
        user.setField(field);
        user.setDeanGroups(getDeanGroups(preferencesRQ));
        user.setTerm(preferencesRQ.getTerm());
        user.setDegree(preferencesRQ.getDegree());
        userRepository.save(user);
        log.info("setPreferences finished. Send response.");
        httpResponse.setStatus(HttpStatus.OK.value());
        return true;
    }

    private String getDeanGroups(@RequestBody PreferencesRQ preferencesRQ) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Long id : preferencesRQ.getDeanGroupIds()) {
            if (!stringBuilder.toString().isEmpty())
                stringBuilder.append(",");
            stringBuilder.append(id);
        }
        return stringBuilder.toString();
    }


}
