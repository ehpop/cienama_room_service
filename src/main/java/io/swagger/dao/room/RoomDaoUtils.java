package io.swagger.dao.room;

import io.swagger.model.Room;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDaoUtils {

    public static Room mapToRoom(ResultSet resultSet, Integer id) throws SQLException {
        Room room = mapToRoomWithoutId(resultSet);
        room.setId(id);

        return room;
    }

    public static Room mapToRoomWithoutId(ResultSet resultSet) throws SQLException {
        Room room = new Room();
        room.setId(resultSet.getInt("id"));
        room.setCapacity(resultSet.getInt("capacity"));
        room.setName(resultSet.getString("name"));
        room.setRows(resultSet.getInt("rows"));

        return room;
    }

    public static List<Room> mapRooms(ResultSet rs) throws SQLException {
        List<Room> rooms = new ArrayList<>();
        while (rs.next()) {
            Room room = mapToRoomWithoutId(rs);
            rooms.add(room);
        }
        return rooms;
    }

}
