package controller;

import cdm.GetBuildingByDepartmentRS;
import cdm.GetBuildingByNameRS;
import cdm.GetBuildingsRS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import repository.BuildingRepository;
import service.BuildingService;

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
    public GetBuildingsRS getAllBuidings() {
        log.info("getAllBuidings core invoked");
        return buildingService.prepareResultForGetBuildings();
    }

    @RequestMapping(value = "/name", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public GetBuildingByNameRS getBuidingByName(@RequestBody String request) {
        log.info("getBuidingByName core invoked.");
        log.info("RequestBody: " + request.trim());
        return buildingService.prepareResultForGetBuildingByName(request);
    }

    @RequestMapping(value = "/department", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public GetBuildingByDepartmentRS getBuidingsByDepartment(@RequestBody String request) {
        log.info("getBuidingsByDepartment core invoked.");
        log.info("RequestBody: " + request.trim());
        return buildingService.prepareResultForGetBuildingByDepartment(request);
    }
}
