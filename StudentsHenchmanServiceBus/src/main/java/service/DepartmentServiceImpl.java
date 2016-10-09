package service;

import cdm.GetDepartmentByNameRQ;
import cdm.GetDepartmentByNameRS;
import cdm.GetDepartmentsRS;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import repository.DepartmentRepository;

import java.io.IOException;
import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/9/16.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private static final Logger log = LoggerFactory.getLogger(DepartmentService.class);

    @Autowired
    private DepartmentRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public GetDepartmentsRS prepareResultForGetDepartments() {
        GetDepartmentsRS result = new GetDepartmentsRS();
        List<Department> departments = (List<Department>) repository.findAll();
        result.setDepartments(departments);
        if (CollectionUtils.isEmpty(departments)) {
            result.setStatus(HttpStatus.NOT_FOUND.getReasonPhrase());
        } else {
            result.setStatus(HttpStatus.FOUND.getReasonPhrase());
        }
        log.info("ResponseBody: " + result);
        return result;
    }

    @Override
    public GetDepartmentByNameRS prepareResultForGetDepartmentByName(String request) {
        GetDepartmentByNameRS result = new GetDepartmentByNameRS();
        try {
            GetDepartmentByNameRQ getDepartmentByNameRQ = objectMapper.readValue(request, GetDepartmentByNameRQ.class);
            Department department = repository.findByName(getDepartmentByNameRQ.getName());
            result.setDepartment(department);
            if (department != null) {
                result.setStatus(HttpStatus.FOUND.getReasonPhrase());
            } else {
                result.setStatus(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            log.info("ResponseBody: " + result.toString());
            return result;
        } catch (IOException e) {
            result.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
            log.info("Exception: " + e.getMessage().trim());
            log.info("ResponseBody: " + result);
            return result;
        }
    }
}
