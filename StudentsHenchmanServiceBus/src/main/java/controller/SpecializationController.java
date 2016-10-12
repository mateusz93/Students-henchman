package controller;

import cdm.SpecializationRS;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import repository.SpecializationRepository;
import service.SpecializationService;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author Mateusz Wieczorek on 10/12/16.
 */
@RestController
@RequestMapping("/mobile/specializations")
public class SpecializationController {

    private static final Logger log = LoggerFactory.getLogger(SpecializationController.class);

    @Autowired
    private SpecializationRepository repository;

    @Autowired
    private SpecializationService specializationService;


    @RequestMapping(method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public SpecializationRS getSpecialization(@RequestParam(value="name", required=false) String name,
                                              @RequestParam(value="id", required=false) String id,
                                              @RequestParam(value="fieldId", required=false) String fieldId,
                                              HttpServletResponse httpResponse) {
        log.info("getSpecialization core invoked.");
        if (StringUtils.isNotEmpty(name)) {
            log.info("PathParameter: Name=" + name);
            return specializationService.prepareResultForGetSpecializationByName(httpResponse, name);
        } else if (StringUtils.isNotEmpty(id)) {
            log.info("PathParameter: id=" + id);
            return specializationService.prepareResultForGetSpecializationById(httpResponse, id);
        } else if (StringUtils.isNotEmpty(fieldId)) {
            log.info("PathParameter: fieldId=" + fieldId);
            return specializationService.prepareResultForGetSpecializationByFieldId(httpResponse, fieldId);
        }
        return specializationService.prepareResultForGetSpecializations(httpResponse);
    }

}
