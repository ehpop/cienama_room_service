package io.swagger.DAO.Reservation;

import io.swagger.model.Reservation;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;

public class MySqlReservationDao implements ReservationDao{

    private final JdbcTemplate jdbcTemplate;
    private final String reservationsTableName;

    public MySqlReservationDao(JdbcTemplate jdbcTemplate, String reservationsTableName){
        this.jdbcTemplate = jdbcTemplate;
        this.reservationsTableName = reservationsTableName;
    }

    @Override
    public Integer addReservation(Reservation reservation) {
        return null;
    }

    @Override
    public Reservation getReservationById(Integer id) {
        return null;
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
    public boolean updateReservationById(Integer id) {
        return false;
    }
}
