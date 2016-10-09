package service;

import cdm.GetBuildingByDepartmentRS;
import cdm.GetBuildingByNameRQ;
import cdm.GetBuildingByNameRS;
import cdm.GetBuildingsRS;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Building;
import model.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import repository.BuildingRepository;

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
    private ObjectMapper objectMapper;

    @Override
    public GetBuildingByNameRS prepareResultForGetBuildingByName(String request) {
        GetBuildingByNameRS result = new GetBuildingByNameRS();
        try {
            GetBuildingByNameRQ getBuildingByNameRQ = objectMapper.readValue(request, GetBuildingByNameRQ.class);
            Building building = repository.findByName(getBuildingByNameRQ.getName());
            result.setBuilding(building);
            if (building != null) {
                result.setStatus(HttpStatus.FOUND.getReasonPhrase());
            } else {
                result.setStatus(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            log.info("ResponseBody: " + result);
            return result;
        } catch (IOException e) {
            result.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
            log.info("Exception: " + e.getMessage().trim());
            log.info("ResponseBody: " + result);
            return result;
        }
    }

    @Override
    public GetBuildingByDepartmentRS prepareResultForGetBuildingByDepartment(String request) {
        GetBuildingByDepartmentRS result = new GetBuildingByDepartmentRS();
        try {
            Department department = objectMapper.readValue(request, Department.class);
            List<Building> buildings = repository.findByDepartment(department);
            result.setBuildings(buildings);
            if (CollectionUtils.isEmpty(buildings)) {
                result.setStatus(HttpStatus.NOT_FOUND.getReasonPhrase());
            } else {
                result.setStatus(HttpStatus.FOUND.getReasonPhrase());
            }
            log.info("ResponseBody: " + result);
            return result;
        } catch (IOException e) {
            result.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
            log.info("Exception: " + e.getMessage().trim());
            log.info("ResponseBody: " + result);
            return result;
        }
    }

    @Override
    public GetBuildingsRS prepareResultForGetBuildings() {
        GetBuildingsRS result = new GetBuildingsRS();
        List<Building> buildings = (List<Building>) repository.findAll();
        result.setBuildings(buildings);
        if (CollectionUtils.isEmpty(buildings)) {
            result.setStatus(HttpStatus.NOT_FOUND.getReasonPhrase());
        } else {
            result.setStatus(HttpStatus.FOUND.getReasonPhrase());
        }
        log.info("ResponseBody: " + result);
        return result;
    }
}
