package service;

import cdm.GetBuildingByDepartmentRS;
import cdm.GetBuildingByNameRS;
import cdm.GetBuildingsRS;

/**
 * @Author Mateusz Wieczorek on 10/8/16.
 */
public interface BuildingService {

    GetBuildingByNameRS prepareResultForGetBuildingByName(String request);
    GetBuildingByDepartmentRS prepareResultForGetBuildingByDepartment(String request);
    GetBuildingsRS prepareResultForGetBuildings();

}
