package io.swagger.dao.reservation;

import io.swagger.model.Reservation;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

public class MySqlReservationDao implements ReservationDao {

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
            preparedStatement.setString(1, reservation.getCustomerEmail());
            preparedStatement.setInt(2, reservation.getScreeningId());
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
        Reservation reservation = jdbcTemplate.queryForObject(query, ReservationsDaoUtils::mapToReservation);

        if (reservation != null) {
            reservation.setId(id);
        }

        return reservation;
    }

    @Override
    public boolean deleteReservationById(Integer id) {
        int rowsAffected = 0;
        String query = "DELETE FROM " + reservationsTableName + " where id = " + id;

        try {
            rowsAffected += jdbcTemplate.update(query);
        } catch (DataAccessException e){
            return false;
        }

        return rowsAffected > 0;
    }

    @Override
    public List<Reservation> getAllReservations() {
        String query = "SELECT * FROM " + reservationsTableName;

        return jdbcTemplate.query(query, ReservationsDaoUtils::mapToReservations);
    }

    @Override
    public boolean updateReservationById(Reservation reservation, Integer id) {
        String query = "UPDATE " + reservationsTableName + " SET customer_name = ?, screening_id = ?, `date` = ?, seat_number = ? WHERE id = " + id;

        int rowsAffected = jdbcTemplate.update(
                query,
                reservation.getCustomerEmail(),
                reservation.getScreeningId(),
                reservation.getDate().toString(),
                reservation.getSeat()
        );

        reservation.setId(id);

        return rowsAffected > 0;
    }
}
