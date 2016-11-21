package controller;

import cdm.CourseRS;
import model.Course;
import model.DeanGroup;
import model.User;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.CourseRepository;
import repository.DeansGroupRepository;
import repository.UserRepository;
import service.CourseService;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/12/16.
 */
@RestController
@RequestMapping("/mobile/courses")
public class CourseController {

    private static final Logger log = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DeansGroupRepository deansGroupRepository;

    @Autowired
    private CourseService courseService;

    @RequestMapping(method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public CourseRS getCourses(@RequestParam(value="name", required=false) String name,
                               @RequestParam(value="id", required=false) String id,
                               HttpServletResponse httpResponse) {
        log.info("getCourses core invoked");
        if (StringUtils.isNotEmpty(name)) {
            return courseService.prepareResultForGetCourseByName(httpResponse, name);
        } else if (StringUtils.isNotEmpty(id)) {
            return courseService.prepareResultForGetCourseById(httpResponse, id);
        }
        return courseService.prepareResultForGetCourses(httpResponse);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public CourseRS getCoursesByUser(@RequestHeader("email") String email,
                               HttpServletResponse httpResponse) {
        log.info("getCoursesByUser core invoked");
        CourseRS response = new CourseRS();
        User user = userRepository.findByEmail(email);
        List<Course> courses = new ArrayList<>();
        if (StringUtils.isNotBlank(user.getCourses())) {
            for (String id : getUserCourseIdsAsList(user)) {
                Course course = courseRepository.findById(Long.valueOf(id));
                courses.add(course);
            }
        } else {
            for (String id : getUserDeanGroupsIdsAsList(user)) {
                DeanGroup deanGroup = deansGroupRepository.findById(Long.valueOf(id));
                List<Course> course = courseRepository.findByDeanGroup(deanGroup);
                courses.addAll(course);
            }
        }
        response.getCourses().addAll(courses);
        return response;
    }

    private String[] getUserDeanGroupsIdsAsList(User user) {
        return user.getDeanGroups().split(",");
    }

    private String[] getUserCourseIdsAsList(User user) {
        return user.getCourses().split(",");
    }
}
