package controller;

import cdm.SettingsRS;
import model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import repository.*;

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
    private FieldRepository fieldRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DeansGroupRepository deansGroupRepository;

    @RequestMapping(method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public SettingsRS getSettingsData(HttpServletResponse httpResponse) {
        log.info("getSettingsData invoked.");
        SettingsRS result = new SettingsRS();
        result.getDepartments().addAll((Collection<? extends Department>) departmentRepository.findAll());
        result.getFields().addAll((Collection<? extends Field>) fieldRepository.findAll());
        result.getDeanGroups().addAll((Collection<? extends DeanGroup>) deansGroupRepository.findAll());
        log.info("getSettingsData finished. Send response.");
        return result;
    }
}
