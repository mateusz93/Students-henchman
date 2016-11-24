package controller;

import cdm.CourseRS;
import model.Course;
import model.DeanGroup;
import model.DependentDeanGroup;
import model.User;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import repository.CourseRepository;
import repository.DeansGroupRepository;
import repository.DependentDeanGroupRepository;
import repository.UserRepository;
import service.CourseService;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private DependentDeanGroupRepository dependentDeanGroupRepository;

    @Autowired
    private CourseService courseService;

    @RequestMapping(method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public CourseRS getCourses(@RequestParam(value = "name", required = false) String name,
                               @RequestParam(value = "id", required = false) String id,
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
        CourseRS response = new CourseRS();
        User user = userRepository.findByEmail(email);
        if (null == user) {
            log.info("Unauthorized user during downloading courses");
            httpResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
            return null;
        }
        log.info("getCoursesByUser core invoked");
        List<Course> courses = new ArrayList<>();
        Set<DependentDeanGroup> dependentDeanGroups = new HashSet<>();

        if (StringUtils.isNotBlank(user.getCourses())) {
            for (String id : fromStringToList(user.getCourses())) {
                Course course = courseRepository.findById(Long.valueOf(id));
                courses.add(course);
            }
        } else {
            for (String id : fromStringToList(user.getDeanGroups())) {
                DeanGroup deanGroup = deansGroupRepository.findById(Long.valueOf(id));
                List<Course> course = courseRepository.findByDeanGroup(deanGroup);
                DependentDeanGroup dependentDeanGroup = dependentDeanGroupRepository.findByDependentDeanGroupId(deanGroup);
                if (null != dependentDeanGroup)
                    dependentDeanGroups.add(dependentDeanGroup);
                courses.addAll(course);
            }
        }

        for (DependentDeanGroup dependentDeanGroup : dependentDeanGroups) {
            DeanGroup deanGroup = deansGroupRepository.findById(dependentDeanGroup.getCommonDeanGroupId().getId());
            List<Course> course = courseRepository.findByDeanGroup(deanGroup);
            courses.addAll(course);
        }
        if (courses.size() > 0)
            httpResponse.setStatus(HttpStatus.OK.value());
        else
            httpResponse.setStatus(HttpStatus.NO_CONTENT.value());
        response.getCourses().addAll(courses);

        return response;
    }

    private String[] fromStringToList(String stringValue) {
        if (null != stringValue)
            return stringValue.split(",");
        else
            return new String[]{};
    }
}
