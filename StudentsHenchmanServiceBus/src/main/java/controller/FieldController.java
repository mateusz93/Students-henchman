package controller;

import cdm.FieldRS;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import repository.FieldRepository;
import service.FieldService;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author Mateusz Wieczorek on 10/12/16.
 */
@RestController
@RequestMapping("/mobile/fields")
public class FieldController {

    private static final Logger log = LoggerFactory.getLogger(FieldController.class);

    @Autowired
    private FieldRepository repository;

    @Autowired
    private FieldService fieldService;

    @RequestMapping(method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public FieldRS getField(@RequestParam(value="name", required=false) String name,
                            @RequestParam(value="id", required=false) String id,
                            @RequestParam(value="departmentId", required=false) String departmentId,
                            HttpServletResponse httpResponse) {
        log.info("getField core invoked.");
        if (StringUtils.isNotEmpty(name)) {
            return fieldService.prepareResultForGetFieldByName(httpResponse, name);
        } else if (StringUtils.isNotEmpty(id)) {
            return fieldService.prepareResultForGetFieldById(httpResponse, id);
        } else if (StringUtils.isNotEmpty(departmentId)) {
            return fieldService.prepareResultForGetFieldByDepartmentId(httpResponse, departmentId);
        }
        return fieldService.prepareResultForGetFields(httpResponse);
    }

}
