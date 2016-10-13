package controller;

import cdm.CourseTypeRS;
import cdm.RoomRS;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import repository.RoomRepository;
import service.RoomService;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author Mateusz Wieczorek on 10/13/16.
 */
@RestController
@RequestMapping("/mobile/rooms")
public class RoomController {

    private static final Logger log = LoggerFactory.getLogger(RoomController.class);

    @Autowired
    private RoomRepository repository;

    @Autowired
    private RoomService roomService;

    @RequestMapping(method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public RoomRS getRooms(@RequestParam(value="name", required=false) String name,
                           @RequestParam(value="code", required=false) String code,
                           @RequestParam(value="id", required=false) String id,
                           HttpServletResponse httpResponse) {
        log.info("getRooms core invoked");
        if (StringUtils.isNotEmpty(code)) {
            return roomService.prepareResultForGetRoomByCode(httpResponse, code);
        } else if (StringUtils.isNotEmpty(name)) {
            return roomService.prepareResultForGetRoomByName(httpResponse, name);
        } else if (StringUtils.isNotEmpty(id)) {
            return roomService.prepareResultForGetRoomById(httpResponse, id);
        }
        return roomService.prepareResultForGetRooms(httpResponse);
    }
}
