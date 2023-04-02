package io.swagger.dao.reservation;

import io.swagger.model.Reservation;
import org.threeten.bp.OffsetDateTime;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationsDaoUtils {

    public static Reservation mapToReservation(ResultSet resultSet, Integer id) throws SQLException {
        Reservation reservation = new Reservation();
        reservation.setId(id);
        reservation.setCustomerName(resultSet.getString("customer_name"));
        reservation.setScreeningInfo(resultSet.getInt("screening_id"));
        reservation.setDate(OffsetDateTime.parse(resultSet.getString("date")));
        reservation.setSeat(resultSet.getInt("seat_number"));

        return reservation;
    }
}
