package io.swagger.dao.reservation;

import io.swagger.model.Reservation;
import org.threeten.bp.OffsetDateTime;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public static List<Reservation> mapToReservations(ResultSet resultSet) throws SQLException {
        List<Reservation> reservations = new ArrayList<>();

        while (resultSet.next()){
            Reservation reservation = new Reservation();
            reservation.setId(resultSet.getInt("id"));
            reservation.setCustomerName(resultSet.getString("customer_name"));
            reservation.setScreeningInfo(resultSet.getInt("screening_id"));
            reservation.setDate(OffsetDateTime.parse(resultSet.getString("date")));
            reservation.setSeat(resultSet.getInt("seat_number"));

            reservations.add(reservation);
        }

        return reservations;
    }
}
