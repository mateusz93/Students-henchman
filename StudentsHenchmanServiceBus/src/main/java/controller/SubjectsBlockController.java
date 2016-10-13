package controller;

import cdm.SubjectsBlockRS;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import repository.SubjectsBlockRepository;
import service.SubjectsBlockService;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author Mateusz Wieczorek on 10/13/16.
 */
@RestController
@RequestMapping("/mobile/subjectsBlocks")
public class SubjectsBlockController {

    private static final Logger log = LoggerFactory.getLogger(SubjectsBlockController.class);

    @Autowired
    private SubjectsBlockRepository repository;

    @Autowired
    private SubjectsBlockService service;

    @RequestMapping(method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public SubjectsBlockRS getSubjectsBlock(@RequestParam(value="name", required=false) String name,
                                            @RequestParam(value="fieldId", required=false) String fieldId,
                                            @RequestParam(value="id", required=false) String id,
                                            HttpServletResponse httpResponse) {
        log.info("getSubjectsBlock core invoked.");
        if (StringUtils.isNotEmpty(name)) {
            return service.prepareResultForGetSubjectByName(httpResponse, name);
        } else if (StringUtils.isNotEmpty(fieldId)) {
            return service.prepareResultForGetSubjectByField(httpResponse, fieldId);
        } else if (StringUtils.isNotEmpty(id)) {
            return service.prepareResultForGetSubjectById(httpResponse, id);
        }
        return service.prepareResultForGetSubjects(httpResponse);
    }
}
