package service;

import cdm.CreateUserRQ;
import cdm.CreateUserRS;
import cdm.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @Author Mateusz Wieczorek on 10/10/16.
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository repository;

    @Autowired
    private ObjectMapper mapper;

    private User result = new User();

    @Override
    public User prepareResultForGetUserByEmail(HttpServletResponse httpResponse, String email) {
        try {
            model.User user = repository.findByEmail(email);
            if (user != null) {
                String userInString = mapper.writeValueAsString(user);
                result = mapper.readValue(userInString, User.class);
                httpResponse.setStatus(HttpStatus.FOUND.value());
            } else {
                httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
            }
            log.info("ResponseBody: " + result.toString());
        } catch (IOException e) {
            log.error("Exception: " + e.getMessage());
        }
        return result;
    }

    @Override
    public User prepareResultForGetUserById(HttpServletResponse httpResponse, String id) {
        try {
            model.User user = repository.findById(Integer.valueOf(id));
            if (user != null) {
                String userInString = mapper.writeValueAsString(user);
                result = mapper.readValue(userInString, User.class);
                httpResponse.setStatus(HttpStatus.FOUND.value());
            } else {
                httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
            }
            log.info("ResponseBody: " + result.toString());
        } catch (IOException e) {
            log.error("Exception: " + e.getMessage());
        }
        return result;
    }

    @Override
    public CreateUserRS createUser(CreateUserRQ request, HttpServletResponse httpResponse) {
        CreateUserRS result = new CreateUserRS();
        if (isNotCorrectRequest(request)) {
            httpResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            return null;
        }
        model.User user = new model.User();
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setSubjectIds(request.getLastName());
        user.setLessonPlanVersion(String.valueOf(LocalDateTime.now().hashCode()));

        user = repository.save(user);
        result.setId((int) user.getId());
        result.setLessonPlanVersion(user.getLessonPlanVersion());
        httpResponse.setStatus(HttpStatus.CREATED.value());
        return result;
    }

    private boolean isNotCorrectRequest(CreateUserRQ request) {
        if (StringUtils.isEmpty(request.getEmail())) {
            log.error("Email is required");
            return true;
        }
        if (StringUtils.isEmpty(request.getFirstName())) {
            log.error("FirstName is required");
            return true;
        }
        if (StringUtils.isEmpty(request.getLastName())) {
            log.error("LastName is required");
            return true;
        }
        return false;
    }
}
