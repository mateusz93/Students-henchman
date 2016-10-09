package controller;

import cdm.DepartmentsRS;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import repository.DepartmentRepository;
import service.DepartmentService;

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
    public DepartmentsRS getDepartment(@RequestParam(value="name", required=false) String name, @RequestParam(value="id", required=false) String id) {
        log.info("getDepartment core invoked.");
        if (StringUtils.isNotEmpty(name)) {
            log.info("PathParameter: Name=" + name);
            return departmentService.prepareResultForGetDepartmentByName(name);
        } else if (StringUtils.isNotEmpty(id)) {
            log.info("PathParameter: id=" + id);
            return departmentService.prepareResultForGetDepartmentById(id);
        } else {
            return departmentService.prepareResultForGetDepartments();
        }
    }

}
