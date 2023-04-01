package io.swagger.dao.room;

import io.swagger.model.Room;

import java.util.ArrayList;

public interface RoomDao {
    public Integer addRoom(Room room);

    public Room getRoomById(Integer id);

    public boolean deleteRoomById(Integer id);

    public ArrayList<Room> getAllRooms();

    public boolean updateRoomById(Integer id);
}
