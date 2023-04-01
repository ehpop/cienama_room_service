package io.swagger.dao.room;

import io.swagger.model.Room;
import org.springframework.dao.DataAccessException;
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

        addListOfMovieToRoom(room.getId(), room.getMovies());

        return room.getId();
    }

    @Override
    public Room getRoomById(Integer id) {
        return null;
    }

    @Override
    public boolean deleteRoomById(Integer id) {
        int rowsAffected = 0;

        String query = "DELETE FROM " + "room_movies" + " WHERE room_id = " + id;
        jdbcTemplate.update(query);

        query = "DELETE FROM " + roomsTableName + " WHERE id = " + id;
        try {
            rowsAffected = jdbcTemplate.update(query);
        } catch (EmptyResultDataAccessException e) {
            return false;
        }

        return rowsAffected > 0;
    }

    @Override
    public ArrayList<Room> getAllRooms() {
        String query = "SELECT * FROM " + roomsTableName;

        List<Room> rooms = jdbcTemplate.query(query, RoomDaoUtils::mapToRoom);

        //!TODO: replace with app.settings
        String queryMovieId = "SELECT movie_id FROM " + "room_movies" + " WHERE room_id = ?";
        for (Room room : rooms) {
            Integer roomId = room.getId();
            List<Integer> movieIds = jdbcTemplate.query(queryMovieId, ps -> {
                ps.setInt(1, roomId);
            }, (rs, rowNum) -> rs.getInt("movie_id"));
            room.setMovies(movieIds);
        }

        return (ArrayList<Room>) rooms;
    }

    @Override
    public boolean updateRoomById(Integer id) {
        return false;
    }

    private boolean addListOfMovieToRoom(Integer roomId, List<Integer> moviesId) {
        //! TODO add var to app.settings
        String query = "INSERT INTO " + "room_movies" + " (room_id, movie_id) VALUES(?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        int rowsAffected = 0;
        for (Integer movieId : moviesId) {
            rowsAffected += jdbcTemplate.update(con -> {
                PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, roomId);
                ps.setInt(2, movieId);
                return ps;
            }, keyHolder);
        }


        return rowsAffected > 0;
    }

}
