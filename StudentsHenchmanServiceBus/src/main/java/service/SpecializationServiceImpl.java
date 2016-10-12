package service;

import cdm.SpecializationRS;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Field;
import model.Specialization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import repository.FieldRepository;
import repository.SpecializationRepository;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/12/16.
 */
@Service
public class SpecializationServiceImpl implements SpecializationService {

    private static final Logger log = LoggerFactory.getLogger(SpecializationService.class);

    @Autowired
    private SpecializationRepository specializationRepository;

    @Autowired
    private FieldRepository fieldRepository;

    @Autowired
    private ObjectMapper mapper;

    @Override
    public SpecializationRS prepareResultForGetSpecializationByName(HttpServletResponse httpResponse, String name) {
        SpecializationRS result = new SpecializationRS();
        Specialization specialization = specializationRepository.findByName(name);
        if (specialization != null) {
            result.getSpecializations().add(specialization);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        } else {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }

    @Override
    public SpecializationRS prepareResultForGetSpecializationById(HttpServletResponse httpResponse, String id) {
        SpecializationRS result = new SpecializationRS();
        Specialization specialization = specializationRepository.findById(Long.valueOf(id));
        if (specialization != null) {
            result.getSpecializations().add(specialization);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        } else {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }

    @Override
    public SpecializationRS prepareResultForGetSpecializations(HttpServletResponse httpResponse) {
        SpecializationRS result = new SpecializationRS();
        List<Specialization> specializations = (List<Specialization>) specializationRepository.findAll();
        if (CollectionUtils.isEmpty(specializations)) {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        } else {
            result.getSpecializations().addAll(specializations);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }

    @Override
    public SpecializationRS prepareResultForGetSpecializationByFieldId(HttpServletResponse httpResponse, String fieldId) {
        SpecializationRS result = new SpecializationRS();
        Field field = fieldRepository.findById(Long.valueOf(fieldId));
        List<Specialization> specializations = specializationRepository.findByField(field);
        if (CollectionUtils.isEmpty(specializations)) {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        } else {
            result.getSpecializations().addAll(specializations);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }
}
