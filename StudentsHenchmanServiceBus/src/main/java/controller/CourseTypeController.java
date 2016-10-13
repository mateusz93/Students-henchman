package controller;

import cdm.CourseTypeRS;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import repository.CourseTypeRepository;
import service.CourseTypeService;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author Mateusz Wieczorek on 10/13/16.
 */
@RestController
@RequestMapping("/mobile/courseTypes")
public class CourseTypeController {

    private static final Logger log = LoggerFactory.getLogger(CourseTypeController.class);

    @Autowired
    private CourseTypeRepository repository;

    @Autowired
    private CourseTypeService courseTypeService;

    @RequestMapping(method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public CourseTypeRS getCourseTypes(@RequestParam(value="type", required=false) String type,
                                       @RequestParam(value="id", required=false) String id,
                                       HttpServletResponse httpResponse) {
        log.info("getCourseTypes core invoked");
        if (StringUtils.isNotEmpty(type)) {
            return courseTypeService.prepareResultForGetCourseTypeByType(httpResponse, type);
        } else if (StringUtils.isNotEmpty(id)) {
            return courseTypeService.prepareResultForGetCourseTypeById(httpResponse, id);
        }
        return courseTypeService.prepareResultForGetCourseTypes(httpResponse);
    }

}
