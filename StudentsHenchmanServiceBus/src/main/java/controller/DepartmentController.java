package controller;

import model.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import repository.DepartmentRepository;

import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/4/16.
 */
@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Department> getAllDepartment() {
        log.info("getAllDepartment core invoked");
        return (List<Department>) repository.findAll();
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Object getDepartment(@PathVariable String name) {
        log.info("getDepartment core invoked. Param value: " + name);
        Department department = repository.findByName(name);
        return department != null ? department : HttpStatus.NOT_FOUND;
    }

}
