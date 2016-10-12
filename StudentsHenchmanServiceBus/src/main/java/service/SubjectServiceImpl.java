package service;

import cdm.SpecializationRS;
import cdm.SubjectRS;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Specialization;
import model.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import repository.SubjectRepository;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/12/16.
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    private static final Logger log = LoggerFactory.getLogger(SubjectService.class);

    @Autowired
    private SubjectRepository repository;

    @Autowired
    private ObjectMapper mapper;

    @Override
    public SubjectRS prepareResultForGetSubjectByName(HttpServletResponse httpResponse, String name) {
        SubjectRS result = new SubjectRS();
        List<Subject> subjects = repository.findByName(name);
        if (CollectionUtils.isEmpty(subjects)) {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        } else {
            result.getSubjects().addAll(subjects);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }

    @Override
    public SubjectRS prepareResultForGetSubjectByCode(HttpServletResponse httpResponse, String code) {
        SubjectRS result = new SubjectRS();
        Subject subject = repository.findByCode(code);
        if (subject != null) {
            result.getSubjects().add(subject);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        } else {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }

    @Override
    public SubjectRS prepareResultForGetSubjectById(HttpServletResponse httpResponse, String id) {
        SubjectRS result = new SubjectRS();
        Subject subject = repository.findById(Long.valueOf(id));
        if (subject != null) {
            result.getSubjects().add(subject);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        } else {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }

    @Override
    public SubjectRS prepareResultForGetSubjects(HttpServletResponse httpResponse) {
        SubjectRS result = new SubjectRS();
        List<Subject> subjects = (List<Subject>) repository.findAll();
        if (CollectionUtils.isEmpty(subjects)) {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        } else {
            result.getSubjects().addAll(subjects);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }
}
