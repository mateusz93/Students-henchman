package service;

import cdm.BuildingsRS;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author Mateusz Wieczorek on 10/8/16.
 */
public interface BuildingService {

    BuildingsRS prepareResultForGetBuildingByName(HttpServletResponse httpResponse, String name);
    BuildingsRS prepareResultForGetBuildingById(HttpServletResponse httpResponse, String id);
    BuildingsRS prepareResultForGetBuildings(HttpServletResponse httpResponse);

}
