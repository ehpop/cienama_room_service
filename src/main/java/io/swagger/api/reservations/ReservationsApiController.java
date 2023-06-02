package io.swagger.api.reservations;

import com.mysql.cj.jdbc.exceptions.SQLError;
import io.swagger.api.reservations.ReservationsApi;
import io.swagger.dao.reservation.ReservationDao;
import io.swagger.model.Reservation;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-03-31T21:52:24.625697542Z[GMT]")
@RestController
@CrossOrigin(origins = "http://localhost:3000",  methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservationsApiController implements ReservationsApi {

    private static final Logger log = LoggerFactory.getLogger(ReservationsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final ReservationDao reservationDao;

    @org.springframework.beans.factory.annotation.Autowired
    public ReservationsApiController(ObjectMapper objectMapper, HttpServletRequest request, ReservationDao reservationDao) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.reservationDao = reservationDao;
    }

    public ResponseEntity<List<Reservation>> reservationsGet() {
        List<Reservation> reservations = reservationDao.getAllReservations();

        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    public ResponseEntity<Void> reservationsIdDelete(@Parameter(in = ParameterIn.PATH, description = "ID of the reservation to delete", required = true, schema = @Schema()) @PathVariable("id") Integer id) {
        if (reservationDao.deleteReservationById(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Reservation> reservationsIdGet(@Parameter(in = ParameterIn.PATH, description = "ID of the reservation to retrieve", required = true, schema = @Schema()) @PathVariable("id") Integer id) {
        try {
            Reservation reservation = reservationDao.getReservationById(id);
            return new ResponseEntity<>(reservation, HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Reservation> reservationsIdPut(@Parameter(in = ParameterIn.PATH, description = "ID of the reservation to update", required = true, schema = @Schema()) @PathVariable("id") Integer id, @Parameter(in = ParameterIn.DEFAULT, description = "Reservation object to update", required = true, schema = @Schema()) @Valid @RequestBody Reservation body) {
        try {
            if (reservationDao.updateReservationById(body, id)) {
                return new ResponseEntity<>(body, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException e) {
            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }
    }

}
