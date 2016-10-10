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

import javax.servlet.http.HttpServletResponse;
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
    private ObjectMapper mapper;

    private DepartmentsRS result = new DepartmentsRS();

    @Override
    public DepartmentsRS prepareResultForGetDepartments(HttpServletResponse httpResponse) {
        try {
            List<Department> departments = (List<Department>) repository.findAll();
            if (CollectionUtils.isEmpty(departments)) {
                httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
            } else {
                for (Department department : departments) {
                    String departmentInString = mapper.writeValueAsString(department);
                    result.getDepartments().add(mapper.readValue(departmentInString, cdm.Department.class));
                }
                httpResponse.setStatus(HttpStatus.FOUND.value());
            }
            log.info("ResponseBody: " + result.toString());
        } catch (IOException e) {
            log.error("Exception: " + e.getMessage());
        }
        return result;
    }

    @Override
    public DepartmentsRS prepareResultForGetDepartmentByName(HttpServletResponse httpResponse, String name) {
        try {
            Department department = repository.findByName(name);
            if (department != null) {
                String departmentInString = mapper.writeValueAsString(department);
                result.getDepartments().add(mapper.readValue(departmentInString, cdm.Department.class));
                httpResponse.setStatus(HttpStatus.FOUND.value());
            } else {
                httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
            }
            log.info("ResponseBody: " + result.toString());
        } catch (IOException e) {
            e.printStackTrace();
            log.error("Exception: " + e.getMessage());
        }
        return result;
    }

    @Override
    public DepartmentsRS prepareResultForGetDepartmentById(HttpServletResponse httpResponse, String id) {
        try {
            Department department = repository.findById(Integer.valueOf(id));
            if (department != null) {
                String departmentInString = mapper.writeValueAsString(department);
                result.getDepartments().add(mapper.readValue(departmentInString, cdm.Department.class));
                httpResponse.setStatus(HttpStatus.FOUND.value());
            } else {
                httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
            }
            log.info("ResponseBody: " + result.toString());
        } catch (IOException e) {
            e.printStackTrace();
            log.error("Exception: " + e.getMessage());
        }
        return result;
    }
}
