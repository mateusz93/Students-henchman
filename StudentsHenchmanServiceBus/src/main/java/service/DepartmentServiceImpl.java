package service;

import cdm.DepartmentsRS;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import repository.DepartmentRepository;

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
    public DepartmentsRS prepareResultForGetDepartments() {
        DepartmentsRS result = new DepartmentsRS();
        List<Department> departments = (List<Department>) repository.findAll();
        if (CollectionUtils.isEmpty(departments)) {
            result.setStatus(HttpStatus.NOT_FOUND.getReasonPhrase());
        } else {
            result.setDepartments(departments);
            result.setStatus(HttpStatus.FOUND.getReasonPhrase());
        }
        log.info("ResponseBody: " + result);
        return result;
    }

    @Override
    public DepartmentsRS prepareResultForGetDepartmentByName(String name) {
        DepartmentsRS result = new DepartmentsRS();
        Department department = repository.findByName(name);
        if (department != null) {
            result.getDepartments().add(department);
            result.setStatus(HttpStatus.FOUND.getReasonPhrase());
        } else {
            result.setStatus(HttpStatus.NOT_FOUND.getReasonPhrase());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }

    @Override
    public DepartmentsRS prepareResultForGetDepartmentById(String id) {
        DepartmentsRS result = new DepartmentsRS();
        Department department = repository.findById(Integer.valueOf(id));
        if (department != null) {
            result.getDepartments().add(department);
            result.setStatus(HttpStatus.FOUND.getReasonPhrase());
        } else {
            result.setStatus(HttpStatus.NOT_FOUND.getReasonPhrase());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }
}
