package service;

import cdm.SubjectsBlockRS;
import model.Field;
import model.SubjectsBlock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import repository.FieldRepository;
import repository.SubjectsBlockRepository;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/13/16.
 */
@Service
public class SubjectsBlockServiceImpl implements SubjectsBlockService {

    private static final Logger log = LoggerFactory.getLogger(SubjectsBlockService.class);

    @Autowired
    private SubjectsBlockRepository subjectsBlockRepository;

    @Autowired
    private FieldRepository fieldRepository;

    @Override
    public SubjectsBlockRS prepareResultForGetSubjectByField(HttpServletResponse httpResponse, String fieldId) {
        log.info("PathParameter: fieldId=" + fieldId);
        SubjectsBlockRS result = new SubjectsBlockRS();
        Field field = fieldRepository.findById(Long.valueOf(fieldId));
        List<SubjectsBlock> subjectsBlocks = subjectsBlockRepository.findByField(field);
        if (CollectionUtils.isEmpty(subjectsBlocks)) {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        } else {
            result.getSubjectsBlocks().addAll(subjectsBlocks);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }

    @Override
    public SubjectsBlockRS prepareResultForGetSubjectByName(HttpServletResponse httpResponse, String name) {
        log.info("PathParameter: name=" + name);
        SubjectsBlockRS result = new SubjectsBlockRS();
        List<SubjectsBlock> subjectsBlocks = subjectsBlockRepository.findByName(name);
        if (CollectionUtils.isEmpty(subjectsBlocks)) {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        } else {
            result.getSubjectsBlocks().addAll(subjectsBlocks);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }

    @Override
    public SubjectsBlockRS prepareResultForGetSubjectById(HttpServletResponse httpResponse, String id) {
        log.info("PathParameter: id=" + id);
        SubjectsBlockRS result = new SubjectsBlockRS();
        SubjectsBlock subjectsBlock = subjectsBlockRepository.findById(Long.valueOf(id));
        if (subjectsBlock != null) {
            result.getSubjectsBlocks().add(subjectsBlock);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        } else {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }

    @Override
    public SubjectsBlockRS prepareResultForGetSubjects(HttpServletResponse httpResponse) {
        SubjectsBlockRS result = new SubjectsBlockRS();
        List<SubjectsBlock> subjectsBlocks = (List<SubjectsBlock>) subjectsBlockRepository.findAll();
        if (CollectionUtils.isEmpty(subjectsBlocks)) {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        } else {
            result.getSubjectsBlocks().addAll(subjectsBlocks);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }
}
