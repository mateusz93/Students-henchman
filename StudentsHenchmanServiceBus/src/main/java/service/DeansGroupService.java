package service;

import cdm.DeansGroupRS;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author Mateusz Wieczorek on 10/12/16.
 */
public interface DeansGroupService {

    DeansGroupRS prepareResultForGetDeansGroupByName(HttpServletResponse httpResponse, String name);
    DeansGroupRS prepareResultForGetDeansGroupById(HttpServletResponse httpResponse, String id);
    DeansGroupRS prepareResultForGetDeansGroups(HttpServletResponse httpResponse);

}
