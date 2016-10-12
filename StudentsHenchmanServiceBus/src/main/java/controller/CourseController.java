package controller;

import cdm.CourseRS;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import repository.CourseRepository;
import service.CourseService;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author Mateusz Wieczorek on 10/12/16.
 */
@RestController
@RequestMapping("/mobile/courses")
public class CourseController {

    private static final Logger log = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private CourseRepository repository;

    @Autowired
    private CourseService courseService;

    @RequestMapping(method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public CourseRS getCourses(@RequestParam(value="name", required=false) String name,
                               @RequestParam(value="id", required=false) String id,
                               HttpServletResponse httpResponse) {
        log.info("getCourses core invoked");
        if (StringUtils.isNotEmpty(name)) {
            log.info("PathParameter: Name=" + name);
            return courseService.prepareResultForGetCourseByName(httpResponse, name);
        } else if (StringUtils.isNotEmpty(id)) {
            log.info("PathParameter: id=" + id);
            return courseService.prepareResultForGetCourseById(httpResponse, id);
        }
        return courseService.prepareResultForGetCourses(httpResponse);
    }
}
