package io.swagger.api;

import io.swagger.model.Movie;
import io.swagger.model.Reservation;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-03-31T17:46:47.268366723Z[GMT]")
@RestController
public class MoviesApiController implements MoviesApi {

    private static final Logger log = LoggerFactory.getLogger(MoviesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public MoviesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Movie>> moviesGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Movie>>(objectMapper.readValue("[ {\n  \"duration\" : 1,\n  \"director\" : \"director\",\n  \"id\" : 0,\n  \"title\" : \"title\",\n  \"ageCategory\" : 6\n}, {\n  \"duration\" : 1,\n  \"director\" : \"director\",\n  \"id\" : 0,\n  \"title\" : \"title\",\n  \"ageCategory\" : 6\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Movie>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Movie>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> moviesIdDelete(@Min(1)@Parameter(in = ParameterIn.PATH, description = "ID of the movie to delete", required=true, schema=@Schema(allowableValues={ "1" }, minimum="1"
)) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Movie>> moviesIdGet(@Min(1)@Parameter(in = ParameterIn.PATH, description = "ID of the movie to get", required=true, schema=@Schema(allowableValues={ "1" }, minimum="1"
)) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Movie>>(objectMapper.readValue("[ {\n  \"duration\" : 1,\n  \"director\" : \"director\",\n  \"id\" : 0,\n  \"title\" : \"title\",\n  \"ageCategory\" : 6\n}, {\n  \"duration\" : 1,\n  \"director\" : \"director\",\n  \"id\" : 0,\n  \"title\" : \"title\",\n  \"ageCategory\" : 6\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Movie>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Movie>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Movie> moviesIdPut(@Min(1)@Parameter(in = ParameterIn.PATH, description = "ID of the movie to update", required=true, schema=@Schema(allowableValues={ "1" }, minimum="1"
)) @PathVariable("id") Integer id,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Movie body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Movie>(objectMapper.readValue("{\n  \"duration\" : 1,\n  \"director\" : \"director\",\n  \"id\" : 0,\n  \"title\" : \"title\",\n  \"ageCategory\" : 6\n}", Movie.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Movie>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Movie>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> moviesIdReservePost(@Parameter(in = ParameterIn.PATH, description = "ID of the movie to reserve", required=true, schema=@Schema()) @PathVariable("id") Integer id,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Reservation body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Movie> moviesPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Movie body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Movie>(objectMapper.readValue("{\n  \"duration\" : 1,\n  \"director\" : \"director\",\n  \"id\" : 0,\n  \"title\" : \"title\",\n  \"ageCategory\" : 6\n}", Movie.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Movie>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Movie>(HttpStatus.NOT_IMPLEMENTED);
    }

}
