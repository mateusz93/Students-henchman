package service;

import cdm.BuildingsRS;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Building;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import repository.BuildingRepository;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/8/16.
 */
@Service
public class BuildingServiceImpl implements BuildingService {

    private static final Logger log = LoggerFactory.getLogger(BuildingService.class);

    @Autowired
    private BuildingRepository repository;

    @Autowired
    private ObjectMapper mapper;

    @Override
    public BuildingsRS prepareResultForGetBuildingByName(HttpServletResponse httpResponse, String name) {
        BuildingsRS result = new BuildingsRS();
        Building building = repository.findByName(name);
        if (building != null) {
            result.getBuildings().add(building);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        } else {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }

    @Override
    public BuildingsRS prepareResultForGetBuildingById(HttpServletResponse httpResponse, String id) {
        BuildingsRS result = new BuildingsRS();
        Building building = repository.findById(Integer.valueOf(id));
        if (building != null) {
            result.getBuildings().add(building);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        } else {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }

    @Override
    public BuildingsRS prepareResultForGetBuildings(HttpServletResponse httpResponse) {
        BuildingsRS result = new BuildingsRS();
        List<Building> buildings = (List<Building>) repository.findAll();
        if (CollectionUtils.isEmpty(buildings)) {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        } else {
            result.getBuildings().addAll(buildings);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }
}
