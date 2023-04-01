package io.swagger.dao.room;

import io.swagger.model.Room;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomDaoUtils {

    public static Room mapToRoom(ResultSet resultSet, Integer id) throws SQLException {
        Room room = new Room();
        room.setId(id);
        room.setCapacity(resultSet.getInt("capacity"));
        room.setName(resultSet.getString("name"));
        room.setRows(resultSet.getInt("rows"));
        room.setMovies(new ArrayList<>());

        return room;
    }

}
