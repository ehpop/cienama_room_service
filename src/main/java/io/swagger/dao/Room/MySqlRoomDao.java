package io.swagger.DAO.Room;

import io.swagger.model.Room;
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
        String query = "INSERT INTO " + roomsTableName + " (name, capacity) VALUES(?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, room.getName());
            ps.setInt(2, room.getCapacity());
            return ps;
        }, keyHolder);

        room.setId(Objects.requireNonNull(keyHolder.getKey()).intValue());

        addListOfMovieToRoom(room.getId(), room.getIdsOfMoviesInRoom());
        addListOfSeatsToRoom(room.getId(), room.getIdsOfSeatsInRoom());

        return room.getId();
    }

    @Override
    public Room getRoomById(Integer id) {
        return null;
    }

    @Override
    public boolean deletedRoomById(Integer id) {
        return false;
    }

    @Override
    public ArrayList<Room> getAllRooms() {
        String query = "SELECT * FROM " + roomsTableName;

        List<Room> rooms = jdbcTemplate.query(query, RoomDaoUtils::mapToRoom);

        //!TODO: replace with app.settings
        String queryMovieId = "SELECT movie_id FROM" + "room_movies" + " WHERE room_id = ?";
        String querySeatId = "SELECT seat_id FROM" + "room_seat" + " WHERE room_id = ?";
        for (Room room : rooms) {
            Integer roomId = room.getId();
            List<Integer> movieIds = jdbcTemplate.query(queryMovieId, new Object[]{roomId}, new RowMapper<Integer>() {
                @Override
                public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return rs.getInt("movie_id");
                }
            });
            List<Integer> seatIds = jdbcTemplate.query(querySeatId, new Object[]{roomId}, new RowMapper<Integer>() {
                @Override
                public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return rs.getInt("seat_id");
                }
            });

            room.setMovies(movieIds);
        }
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

    private boolean addListOfSeatsToRoom(Integer roomId, List<Integer> seatsId) {
        //! TODO add var to app.settings
        String query = "INSERT INTO " + "room_seats" + " (room_id, seat_id) VALUES(?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowsAffected = 0;
        for (Integer seatId : seatsId) {
            rowsAffected += jdbcTemplate.update(con -> {
                PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, roomId);
                ps.setInt(2, seatId);

                return ps;
            }, keyHolder);
        }
        return rowsAffected > 0;
    }
}
