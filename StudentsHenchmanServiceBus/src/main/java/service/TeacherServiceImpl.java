package service;

import cdm.TeacherRS;
import model.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import repository.TeacherRepository;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/12/16.
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    private static final Logger log = LoggerFactory.getLogger(TeacherService.class);

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public TeacherRS prepareResultForGetTeacherByName(HttpServletResponse httpResponse, String name) {
        log.info("PathParameter: name=" + name);
        TeacherRS result = new TeacherRS();
        List<Teacher> teachers = teacherRepository.findByName(name);
        if (null != teachers && !teachers.isEmpty()) {
            result.getTeachers().addAll(teachers);
            httpResponse.setStatus(HttpStatus.OK.value());
        } else {
            httpResponse.setStatus(HttpStatus.NO_CONTENT.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }

    @Override
    public TeacherRS prepareResultForGetTeacherById(HttpServletResponse httpResponse, String id) {
        log.info("PathParameter: id=" + id);
        TeacherRS result = new TeacherRS();
        Teacher teacher = teacherRepository.findById(Long.valueOf(id));
        if (null != teacher) {
            result.getTeachers().add(teacher);
            httpResponse.setStatus(HttpStatus.OK.value());
        } else {
            httpResponse.setStatus(HttpStatus.NO_CONTENT.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }

    @Override
    public TeacherRS prepareResultForGetTeacherByEmail(HttpServletResponse httpResponse, String email) {
        log.info("PathParameter: email=" + email);
        TeacherRS result = new TeacherRS();
        Teacher teacher = teacherRepository.findByEmail(email);
        if (teacher != null) {
            result.getTeachers().add(teacher);
            httpResponse.setStatus(HttpStatus.OK.value());
        } else {
            httpResponse.setStatus(HttpStatus.NO_CONTENT.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }

    @Override
    public TeacherRS prepareResultForGetTeachers(HttpServletResponse httpResponse) {
        TeacherRS result = new TeacherRS();
        List<Teacher> teachers = (List<Teacher>) teacherRepository.findAll();
        if (null != teachers && !CollectionUtils.isEmpty(teachers)) {
            result.getTeachers().addAll(teachers);
            httpResponse.setStatus(HttpStatus.OK.value());
        } else {
            httpResponse.setStatus(HttpStatus.NO_CONTENT.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }

}
