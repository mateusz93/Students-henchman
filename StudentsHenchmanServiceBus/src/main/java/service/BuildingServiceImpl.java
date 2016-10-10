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
import java.io.IOException;
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

    private BuildingsRS result = new BuildingsRS();

    @Override
    public BuildingsRS prepareResultForGetBuildingByName(HttpServletResponse httpResponse, String name) {
        try {
            Building building = repository.findByName(name);
            if (building != null) {
                String buildingInString = mapper.writeValueAsString(building);
                result.getBuildings().add(mapper.readValue(buildingInString, cdm.Building.class));
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
    public BuildingsRS prepareResultForGetBuildingById(HttpServletResponse httpResponse, String id) {
        try {
            Building building = repository.findById(Integer.valueOf(id));
            if (building != null) {
                String buildingInString = mapper.writeValueAsString(building);
                result.getBuildings().add(mapper.readValue(buildingInString, cdm.Building.class));
                httpResponse.setStatus(HttpStatus.FOUND.value());
            } else {
                httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
            }
            log.info("ResponseBody: " + result.toString());
        } catch (IOException e) {
            log.error("Exception: " + e.getMessage());
        }
        return result;
    }

    @Override
    public BuildingsRS prepareResultForGetBuildings(HttpServletResponse httpResponse) {
        try {
            List<Building> buildings = (List<Building>) repository.findAll();
            if (CollectionUtils.isEmpty(buildings)) {
                httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
            } else {
                for (Building building : buildings) {
                    String buildingInString = mapper.writeValueAsString(building);
                    result.getBuildings().add(mapper.readValue(buildingInString, cdm.Building.class));
                }
                httpResponse.setStatus(HttpStatus.FOUND.value());
            }
            log.info("ResponseBody: " + result.toString());
        } catch (IOException e) {
            log.error("Exception: " + e.getMessage());
        }
        return result;
    }
}
