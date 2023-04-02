package io.swagger.api.movies;

import io.swagger.dao.movie.MovieDao;
import io.swagger.dao.movie.MySqlMovieDao;
import io.swagger.model.Movie;
import io.swagger.model.Reservation;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-03-31T17:46:47.268366723Z[GMT]")
@RestController
public class MoviesApiController implements MoviesApi {

    private static final Logger log = LoggerFactory.getLogger(MoviesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final MovieDao movieDao;

    @Autowired
    public MoviesApiController(ObjectMapper objectMapper, HttpServletRequest request, MovieDao movieDao) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.movieDao = movieDao;
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
        Movie movie = movieDao.getMovieById(id);

        if (movie == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(Collections.singletonList(movie), HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<Movie> moviesIdPut(@Min(1) @Parameter(in = ParameterIn.PATH, description = "ID of the movie to update", required = true, schema = @Schema(allowableValues = {"1"}, minimum = "1"
    )) @PathVariable("id") Integer id, @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody Movie body) {
        boolean success = movieDao.updateMovieById(body, id);

        if (success) {
            return new ResponseEntity<>(body, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }
    }

    //! TODO
    @Override
    public ResponseEntity<Void> moviesIdReservePost(@Parameter(in = ParameterIn.PATH, description = "ID of the movie to reserve", required = true, schema = @Schema()) @PathVariable("id") Integer id, @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody Reservation body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<Movie> moviesPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody Movie body) {
        Integer newMoviesId = movieDao.addMovie(body);

        return new ResponseEntity<Movie>(body, HttpStatus.CREATED);
    }

}
