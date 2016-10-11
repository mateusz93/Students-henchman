package controller;

import cdm.CreateUserRQ;
import cdm.CreateUserRS;
import model.User;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import repository.UserRepository;
import service.UserService;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author Mateusz Wieczorek on 10/10/16.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public User getUser(@RequestParam(value="id", required=false) String id,
                        @RequestParam(value="email", required=false) String email,
                        HttpServletResponse httpResponse) {
        log.info("getUser core invoked.");
        if (StringUtils.isNotEmpty(id)) {
            log.info("PathParameter: id=" + id);
            return userService.prepareResultForGetUserById(httpResponse, id);
        } else if (StringUtils.isNotEmpty(email)) {
            log.info("PathParameter: email=" + email);
            return userService.prepareResultForGetUserByEmail(httpResponse, email);
        }
        httpResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        return null;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public CreateUserRS createUser(@RequestBody CreateUserRQ request, HttpServletResponse httpResponse) {
        log.info("createUser core invoked.");
        log.info("RequestBody: " + request.toString());
        return userService.createUser(request, httpResponse);
    }
}
