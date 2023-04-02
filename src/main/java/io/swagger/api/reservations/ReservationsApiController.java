package io.swagger.api.reservations;

import io.swagger.dao.reservation.ReservationDao;
import io.swagger.model.Reservation;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-03-31T21:52:24.625697542Z[GMT]")
@RestController
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

    public ResponseEntity<List<Reservation>> reservationsGet(@NotNull @Parameter(in = ParameterIn.QUERY, description = "User to retrieve reservations for" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "user", required = true) String user) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Reservation>>(objectMapper.readValue("[ {\n  \"seat\" : 1,\n  \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"screeningInfo\" : 6,\n  \"id\" : 0,\n  \"customerName\" : \"customerName\"\n}, {\n  \"seat\" : 1,\n  \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"screeningInfo\" : 6,\n  \"id\" : 0,\n  \"customerName\" : \"customerName\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Reservation>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Reservation>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> reservationsIdDelete(@Parameter(in = ParameterIn.PATH, description = "ID of the reservation to delete", required=true, schema=@Schema()) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Reservation> reservationsIdGet(@Parameter(in = ParameterIn.PATH, description = "ID of the reservation to retrieve", required=true, schema=@Schema()) @PathVariable("id") Integer id) {
        try {
            Reservation reservation = reservationDao.getReservationById(id);
            return new ResponseEntity<>(reservation, HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Reservation> reservationsIdPut(@Parameter(in = ParameterIn.PATH, description = "ID of the reservation to update", required=true, schema=@Schema()) @PathVariable("id") Integer id,@Parameter(in = ParameterIn.DEFAULT, description = "Reservation object to update", required=true, schema=@Schema()) @Valid @RequestBody Reservation body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Reservation>(objectMapper.readValue("{\n  \"seat\" : 1,\n  \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"screeningInfo\" : 6,\n  \"id\" : 0,\n  \"customerName\" : \"customerName\"\n}", Reservation.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Reservation>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Reservation>(HttpStatus.NOT_IMPLEMENTED);
    }

}
