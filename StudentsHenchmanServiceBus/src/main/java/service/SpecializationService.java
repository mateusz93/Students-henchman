package service;

import cdm.SpecializationRS;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author Mateusz Wieczorek on 10/12/16.
 */
public interface SpecializationService {

    SpecializationRS prepareResultForGetSpecializationByName(HttpServletResponse httpResponse, String name);
    SpecializationRS prepareResultForGetSpecializationById(HttpServletResponse httpResponse, String id);
    SpecializationRS prepareResultForGetSpecializations(HttpServletResponse httpResponse);
    SpecializationRS prepareResultForGetSpecializationByFieldId(HttpServletResponse httpResponse, String fieldId);
}
