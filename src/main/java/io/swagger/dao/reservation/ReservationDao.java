package io.swagger.dao.reservation;

import io.swagger.model.Reservation;

import java.util.List;

public interface ReservationDao {
    public Integer addReservation(Reservation reservation);

    public Reservation getReservationById(Integer id);

    public boolean deleteReservationById(Integer id);

    public List<Reservation> getAllReservations();

    public boolean updateReservationById(Reservation reservation, Integer id);
}
