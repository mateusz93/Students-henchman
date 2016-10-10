package controller;

import cdm.BuildingsRS;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import repository.BuildingRepository;
import service.BuildingService;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author Mateusz Wieczorek on 10/8/16.
 */
@RestController
@RequestMapping("/buildings")
public class BuildingController {

    private static final Logger log = LoggerFactory.getLogger(BuildingController.class);

    @Autowired
    private BuildingRepository repository;

    @Autowired
    private BuildingService buildingService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public BuildingsRS getBuidings(@RequestParam(value="name", required=false) String name,
                                   @RequestParam(value="id", required=false) String id,
                                   HttpServletResponse httpResponse) {
        log.info("getBuidings core invoked");
        if (StringUtils.isNotEmpty(name)) {
            log.info("PathParameter: Name=" + name);
            return buildingService.prepareResultForGetBuildingByName(httpResponse, name);
        } else if (StringUtils.isNotEmpty(id)) {
            log.info("PathParameter: id=" + id);
            return buildingService.prepareResultForGetBuildingById(httpResponse, id);
        } else {
            return buildingService.prepareResultForGetBuildings(httpResponse);
        }
    }

}
