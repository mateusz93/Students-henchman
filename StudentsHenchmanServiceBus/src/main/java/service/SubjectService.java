package service;

import cdm.SubjectRS;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author Mateusz Wieczorek on 10/12/16.
 */
public interface SubjectService {

    SubjectRS prepareResultForGetSubjectByName(HttpServletResponse httpResponse, String name);
    SubjectRS prepareResultForGetSubjectByCode(HttpServletResponse httpResponse, String code);
    SubjectRS prepareResultForGetSubjectById(HttpServletResponse httpResponse, String id);
    SubjectRS prepareResultForGetSubjects(HttpServletResponse httpResponse);

}
