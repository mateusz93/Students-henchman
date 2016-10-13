package service;

import cdm.RoomRS;
import model.Room;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import repository.RoomRepository;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/13/16.
 */
@Service
public class RoomServiceImpl implements RoomService {

    private static final Logger log = LoggerFactory.getLogger(RoomService.class);

    @Autowired
    private RoomRepository repository;

    @Override
    public RoomRS prepareResultForGetRoomByCode(HttpServletResponse httpResponse, String code) {
        log.info("PathParameter: code=" + code);
        RoomRS result = new RoomRS();
        Room room = repository.findByCode(code);
        if (room != null) {
            result.getRooms().add(room);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        } else {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }

    @Override
    public RoomRS prepareResultForGetRoomByName(HttpServletResponse httpResponse, String name) {
        log.info("PathParameter: name=" + name);
        RoomRS result = new RoomRS();
        List<Room> rooms = (List<Room>) repository.findByName(name);
        if (CollectionUtils.isEmpty(rooms)) {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        } else {
            result.getRooms().addAll(rooms);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }

    @Override
    public RoomRS prepareResultForGetRoomById(HttpServletResponse httpResponse, String id) {
        log.info("PathParameter: id=" + id);
        RoomRS result = new RoomRS();
        Room room = repository.findById(Long.valueOf(id));
        if (room != null) {
            result.getRooms().add(room);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        } else {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }

    @Override
    public RoomRS prepareResultForGetRooms(HttpServletResponse httpResponse) {
        RoomRS result = new RoomRS();
        List<Room> rooms = (List<Room>) repository.findAll();
        if (CollectionUtils.isEmpty(rooms)) {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        } else {
            result.getRooms().addAll(rooms);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }
}
