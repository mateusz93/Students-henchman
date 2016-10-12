package service;

import cdm.CreateUserRQ;
import cdm.CreateUserRS;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import javax.servlet.http.HttpServletResponse;
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

    @Override
    public User prepareResultForGetUserByEmail(HttpServletResponse httpResponse, String email) {
        User user = repository.findByEmail(email);
        if (user != null) {
            httpResponse.setStatus(HttpStatus.FOUND.value());
        } else {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        }
        log.info("ResponseBody: " + user);
        return user;
    }

    @Override
    public User prepareResultForGetUserById(HttpServletResponse httpResponse, String id) {
        User user = repository.findById(Long.valueOf(id));
        if (user != null) {
            httpResponse.setStatus(HttpStatus.FOUND.value());
        } else {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        }
        log.info("ResponseBody: " + user);
        return user;
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
        user.setSubjectIds(getSubjectIds(request));
        user.setLessonPlanVersion(String.valueOf(LocalDateTime.now().hashCode()));
        log.info("Saving user..");
        user = repository.save(user);
        result.setId(user.getId());
        result.setLessonPlanVersion(user.getLessonPlanVersion());
        httpResponse.setStatus(HttpStatus.CREATED.value());
        log.info("ResponseBody: " + user);
        return result;
    }

    private String getSubjectIds(CreateUserRQ request) {
        StringBuilder s = new StringBuilder();
        for (Long id : request.getSubjectIds()) {
            s.append(id).append(",");
        }
        return s.toString();
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
