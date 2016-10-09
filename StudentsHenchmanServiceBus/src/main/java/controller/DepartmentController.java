package controller;

import cdm.GetDepartmentByNameRS;
import cdm.GetDepartmentsRS;
import model.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import repository.DepartmentRepository;
import service.DepartmentService;

import java.util.List;

import static org.hsqldb.lib.tar.TarHeaderField.name;

/**
 * @Author Mateusz Wieczorek on 10/4/16.
 */
@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentRepository repository;

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public GetDepartmentsRS getAllDepartment() {
        log.info("getAllDepartment core invoked");
        return departmentService.prepareResultForGetDepartments();
    }

    @RequestMapping(value = "/name", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public GetDepartmentByNameRS getDepartment(@RequestBody String request) {
        log.info("getDepartment core invoked.");
        log.info("RequestBody: " + request.trim());
        return departmentService.prepareResultForGetDepartmentByName(request);
    }

}
