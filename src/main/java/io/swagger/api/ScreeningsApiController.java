package io.swagger.api;

import io.swagger.dao.screening.ScreeningDao;
import io.swagger.model.Screening;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-03-31T21:52:24.625697542Z[GMT]")
@RestController
public class ScreeningsApiController implements ScreeningsApi {

    private static final Logger log = LoggerFactory.getLogger(ScreeningsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final ScreeningDao screeningDao;

    @org.springframework.beans.factory.annotation.Autowired
    public ScreeningsApiController(ObjectMapper objectMapper, HttpServletRequest request, ScreeningDao screeningDao) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.screeningDao = screeningDao;
    }

    public ResponseEntity<List<Screening>> screeningsGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Screening>>(objectMapper.readValue("[ {\n  \"movie\" : 6,\n  \"startTime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"id\" : 0,\n  \"endTime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"room\" : 1\n}, {\n  \"movie\" : 6,\n  \"startTime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"id\" : 0,\n  \"endTime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"room\" : 1\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Screening>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Screening>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> screeningsIdDelete(@Parameter(in = ParameterIn.PATH, description = "ID of the screening to delete", required=true, schema=@Schema()) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Screening> screeningsIdGet(@Parameter(in = ParameterIn.PATH, description = "ID of the screening to retrieve", required=true, schema=@Schema()) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Screening>(objectMapper.readValue("{\n  \"movie\" : 6,\n  \"startTime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"id\" : 0,\n  \"endTime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"room\" : 1\n}", Screening.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Screening>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Screening>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Screening> screeningsIdPut(@Parameter(in = ParameterIn.PATH, description = "ID of the screening to update", required=true, schema=@Schema()) @PathVariable("id") Integer id,@Parameter(in = ParameterIn.DEFAULT, description = "Screening object to update", required=true, schema=@Schema()) @Valid @RequestBody Screening body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Screening>(objectMapper.readValue("{\n  \"movie\" : 6,\n  \"startTime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"id\" : 0,\n  \"endTime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"room\" : 1\n}", Screening.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Screening>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Screening>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Screening> screeningsPost(@Parameter(in = ParameterIn.DEFAULT, description = "Screening object to be created", required=true, schema=@Schema()) @Valid @RequestBody Screening body) {
        try {
            screeningDao.addScreening(body);

            return new ResponseEntity<>(body, HttpStatus.CREATED);
        } catch (DataAccessException e) {
            log.error(e.getMessage());
        }

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

}
