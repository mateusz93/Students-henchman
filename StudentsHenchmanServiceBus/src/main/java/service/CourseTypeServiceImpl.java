package service;

import cdm.CourseTypeRS;
import model.CourseType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import repository.CourseTypeRepository;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/13/16.
 */
@Service
public class CourseTypeServiceImpl implements CourseTypeService {

    private static final Logger log = LoggerFactory.getLogger(CourseTypeService.class);

    @Autowired
    private CourseTypeRepository repository;

    @Override
    public CourseTypeRS prepareResultForGetCourseTypeByType(HttpServletResponse httpResponse, String type) {
        log.info("PathParameter: type=" + type);
        CourseTypeRS result = new CourseTypeRS();
        CourseType courseType = repository.findByType(type);
        if (courseType != null) {
            result.getCourseTypes().add(courseType);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        } else {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }

    @Override
    public CourseTypeRS prepareResultForGetCourseTypeById(HttpServletResponse httpResponse, String id) {
        log.info("PathParameter: id=" + id);
        CourseTypeRS result = new CourseTypeRS();
        CourseType courseType = repository.findById(Long.valueOf(id));
        if (courseType != null) {
            result.getCourseTypes().add(courseType);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        } else {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }

    @Override
    public CourseTypeRS prepareResultForGetCourseTypes(HttpServletResponse httpResponse) {
        CourseTypeRS result = new CourseTypeRS();
        List<CourseType> courseTypes = (List<CourseType>) repository.findAll();
        if (CollectionUtils.isEmpty(courseTypes)) {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        } else {
            result.getCourseTypes().addAll(courseTypes);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }
}
