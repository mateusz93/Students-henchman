package service;

import cdm.FieldRS;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Department;
import model.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import repository.DepartmentRepository;
import repository.FieldRepository;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/12/16.
 */
@Service
public class FieldServiceImpl implements FieldService {

    private static final Logger log = LoggerFactory.getLogger(FieldService.class);

    @Autowired
    private FieldRepository fieldRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ObjectMapper mapper;

    @Override
    public FieldRS prepareResultForGetFieldByName(HttpServletResponse httpResponse, String name) {
        log.info("PathParameter: Name=" + name);
        FieldRS result = new FieldRS();
        List<Field> fields = fieldRepository.findByName(name);
        if (CollectionUtils.isEmpty(fields)) {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        } else {
            result.getFields().addAll(fields);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }

    @Override
    public FieldRS prepareResultForGetFieldById(HttpServletResponse httpResponse, String id) {
        log.info("PathParameter: id=" + id);
        FieldRS result = new FieldRS();
        Field field = fieldRepository.findById(Long.valueOf(id));
        if (field != null) {
            httpResponse.setStatus(HttpStatus.FOUND.value());
            result.getFields().add(field);
        } else {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }

    @Override
    public FieldRS prepareResultForGetFieldByDepartmentId(HttpServletResponse httpResponse, String departmentId) {
        log.info("PathParameter: departmentId=" + departmentId);
        FieldRS result = new FieldRS();
        Department department = departmentRepository.findById(Long.valueOf(departmentId));
        List<Field> fields = fieldRepository.findByDepartment(department);
        if (CollectionUtils.isEmpty(fields)) {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        } else {
            result.getFields().addAll(fields);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }

    @Override
    public FieldRS prepareResultForGetFields(HttpServletResponse httpResponse) {
        FieldRS result = new FieldRS();
        List<Field> fields = (List<Field>) fieldRepository.findAll();
        if (CollectionUtils.isEmpty(fields)) {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        } else {
            result.getFields().addAll(fields);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }
}
