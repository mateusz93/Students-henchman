package service;

import cdm.SubjectsBlockRS;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author Mateusz Wieczorek on 10/13/16.
 */
public interface SubjectsBlockService {

    SubjectsBlockRS prepareResultForGetSubjectByField(HttpServletResponse httpResponse, String fieldId);
    SubjectsBlockRS prepareResultForGetSubjectByName(HttpServletResponse httpResponse, String name);
    SubjectsBlockRS prepareResultForGetSubjectById(HttpServletResponse httpResponse, String id);
    SubjectsBlockRS prepareResultForGetSubjects(HttpServletResponse httpResponse);

}
