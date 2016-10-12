package service;

import cdm.DepartmentsRS;
import model.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import repository.DepartmentRepository;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/9/16.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private static final Logger log = LoggerFactory.getLogger(DepartmentService.class);

    @Autowired
    private DepartmentRepository repository;

    @Override
    public DepartmentsRS prepareResultForGetDepartments(HttpServletResponse httpResponse) {
        DepartmentsRS result = new DepartmentsRS();
        List<Department> departments = (List<Department>) repository.findAll();
        if (CollectionUtils.isEmpty(departments)) {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        } else {
            result.getDepartments().addAll(departments);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }

    @Override
    public DepartmentsRS prepareResultForGetDepartmentByName(HttpServletResponse httpResponse, String name) {
        log.info("PathParameter: Name=" + name);
        DepartmentsRS result = new DepartmentsRS();
        Department department = repository.findByName(name);
        if (department != null) {
            result.getDepartments().add(department);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        } else {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }

    @Override
    public DepartmentsRS prepareResultForGetDepartmentById(HttpServletResponse httpResponse, String id) {
        log.info("PathParameter: id=" + id);
        DepartmentsRS result = new DepartmentsRS();
        Department department = repository.findById(Long.valueOf(id));
        if (department != null) {
            result.getDepartments().add(department);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        } else {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }
}
