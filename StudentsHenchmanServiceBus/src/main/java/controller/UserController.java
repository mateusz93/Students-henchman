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

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/setPreferences", method = RequestMethod.POST, consumes = "application/json")
    public void setPreferences(@RequestHeader("email") String email,
                               @RequestBody PreferencesRQ preferencesRQ) {
        log.info("setPreferences invoked.");
        User user = userRepository.findByEmail(email);
        Department department = departmentRepository.findById(preferencesRQ.getDepartmentId());
        Field field = fieldRepository.findById(preferencesRQ.getFieldId());
        user.setDepartment(department);
        user.setField(field);
        user.setDeanGroups(preferencesRQ.getDeanGroupIds().toString());
        user.setTerm(preferencesRQ.getTerm());
        user.setDegree(preferencesRQ.getDegree());
        userRepository.save(user);
        log.info("setPreferences finished. Send response.");
    }
}
