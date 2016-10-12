package controller;

import cdm.DeansGroupRS;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import repository.DeansGroupRepository;
import service.DeansGroupService;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author Mateusz Wieczorek on 10/12/16.
 */
@RestController
@RequestMapping("/mobile/deansGroups")
public class DeansGroupController {

    private static final Logger log = LoggerFactory.getLogger(DeansGroupController.class);

    @Autowired
    private DeansGroupRepository repository;

    @Autowired
    private DeansGroupService deansGroupService;

    @RequestMapping(method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public DeansGroupRS getDeansGroup(@RequestParam(value="name", required=false) String name,
                                      @RequestParam(value="id", required=false) String id,
                                      HttpServletResponse httpResponse) {
        log.info("getDeansGroup core invoked.");
        if (StringUtils.isNotEmpty(name)) {
            log.info("PathParameter: Name=" + name);
            return deansGroupService.prepareResultForGetDeansGroupByName(httpResponse, name);
        } else if (StringUtils.isNotEmpty(id)) {
            log.info("PathParameter: id=" + id);
            return deansGroupService.prepareResultForGetDeansGroupById(httpResponse, id);
        }
        return deansGroupService.prepareResultForGetDeansGroups(httpResponse);
    }

}
