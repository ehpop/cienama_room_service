package io.swagger.api.movies;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.dao.movie.MovieDao;
import io.swagger.dao.reservation.ReservationDao;
import io.swagger.model.Movie;
import io.swagger.model.Reservation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.Collections;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-03-31T17:46:47.268366723Z[GMT]")
@RestController
@CrossOrigin("*")
public class MoviesApiController implements MoviesApi {

    private static final Logger log = LoggerFactory.getLogger(MoviesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final MovieDao movieDao;
    private final ReservationDao reservationDao;

    @Autowired
    public MoviesApiController(ObjectMapper objectMapper, HttpServletRequest request, MovieDao movieDao, ReservationDao reservationDao) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.movieDao = movieDao;
        this.reservationDao = reservationDao;
    }

    @Override
    public ResponseEntity<List<Movie>> moviesGet() {
        List<Movie> movies = movieDao.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> moviesIdDelete(@Min(1) @Parameter(in = ParameterIn.PATH, description = "ID of the movie to delete", required = true, schema = @Schema(allowableValues = {"1"}, minimum = "1"
    )) @PathVariable("id") Integer id) {
        if (movieDao.deleteMovieById(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<Movie>> moviesIdGet(@Min(1) @Parameter(in = ParameterIn.PATH, description = "ID of the movie to get", required = true, schema = @Schema(allowableValues = {"1"}, minimum = "1"
    )) @PathVariable("id") Integer id) {
        try {
            Movie movie = movieDao.getMovieById(id);
            if (movie == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(Collections.singletonList(movie), HttpStatus.OK);
            }
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<Movie> moviesIdPut(@Min(1) @Parameter(in = ParameterIn.PATH, description = "ID of the movie to update", required = true, schema = @Schema(allowableValues = {"1"}, minimum = "1"
    )) @PathVariable("id") Integer id, @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody Movie body) {
        boolean success;

        try {
            success = movieDao.updateMovieById(body, id);
            if (success) {
                return new ResponseEntity<>(body, HttpStatus.OK);
            }
        } catch (DataAccessException e) {
            log.error(e.getMessage());
        }

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Void> moviesIdReservePost(@Parameter(in = ParameterIn.PATH, description = "ID of the movie to reserve", required = true, schema = @Schema()) @PathVariable("id") Integer id, @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody Reservation body) {
        //TODO: Check if seat is not taken
        if (movieDao.checkIfMovieExist(id)) {
            try {
                reservationDao.addReservation(body);
                return new ResponseEntity<>(HttpStatus.CREATED);
            } catch (DataAccessException e) {
                log.error(e.getMessage());
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Movie> moviesPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody Movie body) {
        try {
            Integer newMoviesId = movieDao.addMovie(body);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Movie>(body, HttpStatus.CREATED);
    }

}
