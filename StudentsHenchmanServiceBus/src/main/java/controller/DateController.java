package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;

/**
 * @Author Mateusz Wieczorek on 10/1/16.
 */
@RestController
public class DateController {

    @RequestMapping(value = "/date", method = RequestMethod.GET)
    public String getCurrentDate() {
        return LocalDateTime.now().toString();
    }
}
