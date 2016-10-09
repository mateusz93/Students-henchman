package service;

import cdm.GetBuildingsRS;
import model.Building;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import repository.BuildingRepository;

import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/8/16.
 */
@Service
public class BuildingServiceImpl implements BuildingService {

    private static final Logger log = LoggerFactory.getLogger(BuildingService.class);

    @Autowired
    private BuildingRepository repository;

    @Override
    public GetBuildingsRS prepareResultForGetBuildingByName(String name) {
        GetBuildingsRS result = new GetBuildingsRS();
        Building building = repository.findByName(name);
        if (building != null) {
            result.getBuildings().add(building);
            result.setStatus(HttpStatus.FOUND.getReasonPhrase());
        } else {
            result.setStatus(HttpStatus.NOT_FOUND.getReasonPhrase());
        }
        log.info("ResponseBody: " + result);
        return result;
    }

    @Override
    public GetBuildingsRS prepareResultForGetBuildingById(String id) {
        GetBuildingsRS result = new GetBuildingsRS();
        Building building = repository.findById(Integer.valueOf(id));
        if (building != null) {
            result.getBuildings().add(building);
            result.setStatus(HttpStatus.FOUND.getReasonPhrase());
        } else {
            result.setStatus(HttpStatus.NOT_FOUND.getReasonPhrase());
        }
        log.info("ResponseBody: " + result);
        return result;
    }

    @Override
    public GetBuildingsRS prepareResultForGetBuildings() {
        GetBuildingsRS result = new GetBuildingsRS();
        List<Building> buildings = (List<Building>) repository.findAll();
        if (CollectionUtils.isEmpty(buildings)) {
            result.setStatus(HttpStatus.NOT_FOUND.getReasonPhrase());
        } else {
            result.setBuildings(buildings);
            result.setStatus(HttpStatus.FOUND.getReasonPhrase());
        }
        log.info("ResponseBody: " + result);
        return result;
    }
}
