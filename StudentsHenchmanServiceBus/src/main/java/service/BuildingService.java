package service;

import cdm.GetBuildingsRS;

/**
 * @Author Mateusz Wieczorek on 10/8/16.
 */
public interface BuildingService {

    GetBuildingsRS prepareResultForGetBuildingByName(String name);
    GetBuildingsRS prepareResultForGetBuildingById(String id);
    GetBuildingsRS prepareResultForGetBuildings();

}
