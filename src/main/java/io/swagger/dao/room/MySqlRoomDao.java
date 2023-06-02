package io.swagger.dao.room;

import io.swagger.model.Room;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MySqlRoomDao implements RoomDao {

    private final JdbcTemplate jdbcTemplate;
    private final String roomsTableName;

    public MySqlRoomDao(JdbcTemplate jdbcTemplate, String roomsTableName) {
        this.jdbcTemplate = jdbcTemplate;
        this.roomsTableName = roomsTableName;
    }

    @Override
    public Integer addRoom(Room room) {
        String query = "INSERT INTO " + roomsTableName + " (name, capacity, `rows`) VALUES(?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, room.getName());
            ps.setInt(2, room.getCapacity());
            ps.setInt(3, room.getRows());
            return ps;
        }, keyHolder);

        room.setId(Objects.requireNonNull(keyHolder.getKey()).intValue());

        return room.getId();
    }

    @Override
    public Room getRoomById(Integer id) {
        String query = "SELECT * FROM " + roomsTableName + " WHERE id = " + id;

        return jdbcTemplate.queryForObject(query, RoomDaoUtils::mapToRoom);
    }

    @Override
    public boolean deleteRoomById(Integer id) {
        int rowsAffected = 0;

        String query = "DELETE FROM " + "room_movies" + " WHERE room_id = " + id;
        rowsAffected += jdbcTemplate.update(query);

        query = "DELETE FROM " + roomsTableName + " WHERE id = " + id;
        try {
            rowsAffected += jdbcTemplate.update(query);
        } catch (EmptyResultDataAccessException e) {
            return false;
        }

        return rowsAffected > 0;
    }

    @Override
    public List<Room> getAllRooms() {
        String query = "SELECT * FROM " + roomsTableName;

        return jdbcTemplate.query(query, RoomDaoUtils::mapRooms);
    }

    @Override
    public boolean updateRoomById(Room room, Integer id) {
        int rowsAffected = 0;
        rowsAffected += updateRoom(room, id);

        room.setId(id);

        return rowsAffected > 0;
    }

    private int updateRoom(Room room, Integer id) {
        String query = "UPDATE " + roomsTableName + " SET name = ?, capacity = ?, `rows` = ? WHERE id = " + id;

        return jdbcTemplate.update(query, room.getName(), room.getCapacity(), room.getRows());
    }


}
