package controller;

import cdm.SettingsRS;
import model.DeanGroup;
import model.Department;
import model.Field;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import repository.DeansGroupRepository;
import repository.DepartmentRepository;
import repository.FieldRepository;
import repository.UserRepository;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

/**
 * @Author Mateusz Wieczorek on 10/20/16.
 */
@RestController
@RequestMapping("/mobile/settings")
public class SettingsController {

    private static final Logger log = LoggerFactory.getLogger(SettingsController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FieldRepository fieldRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DeansGroupRepository deansGroupRepository;

    @RequestMapping(method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public SettingsRS getSettingsData(@RequestHeader("email") String emailHeader, HttpServletResponse httpResponse) {
        User user = userRepository.findByEmail(emailHeader);
        if (null == user) {
            log.info("Unauthorized user during action downloading settings");
            httpResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
            return null;
        }
        log.info("getSettingsData invoked.");
        SettingsRS result = new SettingsRS();
        result.getDepartments().addAll((Collection<? extends Department>) departmentRepository.findAll());
        result.getFields().addAll((Collection<? extends Field>) fieldRepository.findAll());
        result.getDeanGroups().addAll((Collection<? extends DeanGroup>) deansGroupRepository.findAll());
        log.info("getSettingsData finished. Send response.");
        return result;
    }
}
