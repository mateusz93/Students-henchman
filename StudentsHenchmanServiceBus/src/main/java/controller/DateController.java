package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author Mateusz Wieczorek on 10/1/16.
 */
@RestController
@RequestMapping(value = "/date")
public class DateController {

    private static final Logger log = LoggerFactory.getLogger(DateController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String getCurrentDate() {
        log.info("getCurrentDate core invoked");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.now().format(formatter);
    }
}
