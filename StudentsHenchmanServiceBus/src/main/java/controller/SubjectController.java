package controller;

import cdm.SubjectRS;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import repository.SubjectRepository;
import service.SubjectService;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author Mateusz Wieczorek on 10/12/16.
 */
@RestController
@RequestMapping("/mobile/subjects")
public class SubjectController {

    private static final Logger log = LoggerFactory.getLogger(SubjectController.class);

    @Autowired
    private SubjectRepository repository;

    @Autowired
    private SubjectService subjectService;

    @RequestMapping(method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public SubjectRS getSubject(@RequestParam(value="name", required=false) String name,
                                @RequestParam(value="code", required=false) String code,
                                @RequestParam(value="id", required=false) String id,
                                HttpServletResponse httpResponse) {
        log.info("getSubject core invoked.");
        if (StringUtils.isNotEmpty(name)) {
            return subjectService.prepareResultForGetSubjectByName(httpResponse, name);
        } else if (StringUtils.isNotEmpty(code)) {
            return subjectService.prepareResultForGetSubjectByCode(httpResponse, code);
        } else if (StringUtils.isNotEmpty(id)) {
            return subjectService.prepareResultForGetSubjectById(httpResponse, id);
        }
        return subjectService.prepareResultForGetSubjects(httpResponse);
    }
}
