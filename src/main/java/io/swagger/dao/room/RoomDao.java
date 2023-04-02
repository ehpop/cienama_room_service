package io.swagger.dao.room;

import io.swagger.model.Room;

import java.util.List;

public interface RoomDao {
    public Integer addRoom(Room room);

    public Room getRoomById(Integer id);

    public boolean deleteRoomById(Integer id);

    public List<Room> getAllRooms();

    public boolean updateRoomById(Room room, Integer id);
}
