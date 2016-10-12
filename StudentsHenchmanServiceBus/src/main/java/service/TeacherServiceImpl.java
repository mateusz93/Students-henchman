package service;

import cdm.TeacherRS;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @Autowired
    private ObjectMapper mapper;

    @Override
    public TeacherRS prepareResultForGetTeacherByLastName(HttpServletResponse httpResponse, String lastName) {
        TeacherRS result = new TeacherRS();
        List<Teacher> teachers = teacherRepository.findByLastName(lastName);
        if (CollectionUtils.isEmpty(teachers)) {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        } else {
            result.getTeachers().addAll(teachers);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }

    @Override
    public TeacherRS prepareResultForGetTeacherByFirstName(HttpServletResponse httpResponse, String firstName) {
        TeacherRS result = new TeacherRS();
        List<Teacher> teachers = teacherRepository.findByFirstName(firstName);
        if (CollectionUtils.isEmpty(teachers)) {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        } else {
            result.getTeachers().addAll(teachers);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }

    @Override
    public TeacherRS prepareResultForGetTeacherById(HttpServletResponse httpResponse, String id) {
        TeacherRS result = new TeacherRS();
        Teacher teacher = teacherRepository.findById(Long.valueOf(id));
        if (teacher != null) {
            result.getTeachers().add(teacher);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        } else {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }

    @Override
    public TeacherRS prepareResultForGetTeacherByEmail(HttpServletResponse httpResponse, String email) {
        TeacherRS result = new TeacherRS();
        Teacher teacher = teacherRepository.findByEmail(email);
        if (teacher != null) {
            result.getTeachers().add(teacher);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        } else {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }

    @Override
    public TeacherRS prepareResultForGetTeachers(HttpServletResponse httpResponse) {
        TeacherRS result = new TeacherRS();
        List<Teacher> teachers = (List<Teacher>) teacherRepository.findAll();
        if (CollectionUtils.isEmpty(teachers)) {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        } else {
            result.getTeachers().addAll(teachers);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }

}
