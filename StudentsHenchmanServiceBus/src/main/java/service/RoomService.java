package service;

import cdm.RoomRS;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author Mateusz Wieczorek on 10/13/16.
 */
public interface RoomService {

    RoomRS prepareResultForGetRoomByCode(HttpServletResponse httpResponse, String code);
    RoomRS prepareResultForGetRoomByName(HttpServletResponse httpResponse, String name);
    RoomRS prepareResultForGetRoomById(HttpServletResponse httpResponse, String id);
    RoomRS prepareResultForGetRooms(HttpServletResponse httpResponse);

}
