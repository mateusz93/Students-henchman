package service;

import cdm.CreateUserRQ;
import cdm.CreateUserRS;
import model.User;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author Mateusz Wieczorek on 10/10/16.
 */
public interface UserService {

    User prepareResultForGetUserByEmail(HttpServletResponse httpResponse, String email);
    User prepareResultForGetUserById(HttpServletResponse httpResponse, String id);
    CreateUserRS createUser(CreateUserRQ request, HttpServletResponse httpResponse);
}
