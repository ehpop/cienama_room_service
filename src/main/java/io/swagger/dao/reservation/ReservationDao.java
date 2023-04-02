package io.swagger.dao.reservation;

import io.swagger.model.Reservation;

import java.util.ArrayList;

public interface ReservationDao {
    public Integer addReservation(Reservation reservation);

    public Reservation getReservationById(Integer id);

    public boolean deleteReservationById(Integer id);

    public ArrayList<Reservation> getAllReservations();

    public boolean updateReservationById(Reservation reservation, Integer id);
}
