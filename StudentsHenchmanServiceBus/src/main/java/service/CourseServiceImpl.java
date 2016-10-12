package service;

import cdm.CourseRS;
import model.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import repository.CourseRepository;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/12/16.
 */
@Service
public class CourseServiceImpl implements CourseService {

    private static final Logger log = LoggerFactory.getLogger(CourseService.class);

    @Autowired
    private CourseRepository repository;

    @Override
    public CourseRS prepareResultForGetCourseByName(HttpServletResponse httpResponse, String name) {
        log.info("PathParameter: Name=" + name);
        CourseRS result = new CourseRS();
        List<Course> courses = repository.findByName(name);
        if (CollectionUtils.isEmpty(courses)) {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        } else {
            result.getCourses().addAll(courses);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }

    @Override
    public CourseRS prepareResultForGetCourseById(HttpServletResponse httpResponse, String id) {
        log.info("PathParameter: id=" + id);
        CourseRS result = new CourseRS();
        Course course = repository.findById(Long.valueOf(id));
        if (course != null) {
            result.getCourses().add(course);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        } else {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }

    @Override
    public CourseRS prepareResultForGetCourses(HttpServletResponse httpResponse) {
        CourseRS result = new CourseRS();
        List<Course> courses = (List<Course>) repository.findAll();
        if (CollectionUtils.isEmpty(courses)) {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        } else {
            result.getCourses().addAll(courses);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }
}
