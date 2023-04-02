package io.swagger.dao.reservation;

import io.swagger.model.Reservation;
import io.swagger.model.Screening;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MySqlReservationDao implements ReservationDao{

    private final JdbcTemplate jdbcTemplate;
    private final String reservationsTableName;

    public MySqlReservationDao(JdbcTemplate jdbcTemplate, String reservationsTableName) {
        this.jdbcTemplate = jdbcTemplate;
        this.reservationsTableName = reservationsTableName;
    }

    @Override
    public Integer addReservation(Reservation reservation) {
        String query = "INSERT INTO " + reservationsTableName + " (customer_name, screening_id, `date`, seat_number) VALUES(?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, reservation.getCustomerName());
            preparedStatement.setInt(2, reservation.getScreeningInfo());
            preparedStatement.setString(3, reservation.getDate().toString());
            preparedStatement.setInt(4, reservation.getSeat());
            return preparedStatement;
        }, keyHolder);

        reservation.setId(Objects.requireNonNull(keyHolder.getKey()).intValue());

        return reservation.getId();
    }

    @Override
    public Reservation getReservationById(Integer id) {
        String query = "SELECT * FROM " + reservationsTableName + " WHERE id = " + id;
        List<Reservation> reservation;

        try {
            reservation = jdbcTemplate.query(query, ReservationsDaoUtils::mapToReservation);
            if (reservation.size() == 0) {
                throw new EmptyResultDataAccessException(1);
            }
        } catch (DataAccessException e) {
            throw new EmptyResultDataAccessException(1);
        }

        return reservation.get(0);
    }

    @Override
    public boolean deleteReservationById(Integer id) {
        return false;
    }

    @Override
    public ArrayList<Reservation> getAllReservations() {
        return null;
    }

    @Override
    public boolean updateReservationById(Reservation reservation, Integer id) {
        return false;
    }
}
