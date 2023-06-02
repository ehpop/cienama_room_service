package io.swagger.api.screenings;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.dao.screening.ScreeningDao;
import io.swagger.model.Screening;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-03-31T21:52:24.625697542Z[GMT]")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
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
        List<Screening> list = new ArrayList<>();
        try {
            list = screeningDao.getAllScreenings();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (DataAccessException e) {
            log.error(e.getMessage());
        }

        return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);

    }

    public ResponseEntity<Void> screeningsIdDelete(@Parameter(in = ParameterIn.PATH, description = "ID of the screening to delete", required = true, schema = @Schema()) @PathVariable("id") Integer id) {
        if (screeningDao.deleteScreeningById(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Screening> screeningsIdGet(@Parameter(in = ParameterIn.PATH, description = "ID of the screening to retrieve", required = true, schema = @Schema()) @PathVariable("id") Integer id) {
        try {
            Screening screening = screeningDao.getScreeningById(id);
            if (screening != null) {
                return new ResponseEntity<>(screening, HttpStatus.OK);
            }

        } catch (DataAccessException e) {
            log.error(e.getMessage());
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Screening> screeningsIdPut(@Parameter(in = ParameterIn.PATH, description = "ID of the screening to update", required = true, schema = @Schema()) @PathVariable("id") Integer id, @Parameter(in = ParameterIn.DEFAULT, description = "Screening object to update", required = true, schema = @Schema()) @Valid @RequestBody Screening body) {
        boolean result;

        try {
            result = screeningDao.updateScreeningById(body, id);

            if (result) {
                return new ResponseEntity<>(body, HttpStatus.OK);
            }
        } catch (DataAccessException e) {
            log.error(e.getMessage());
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Screening> screeningsPost(@Parameter(in = ParameterIn.DEFAULT, description = "Screening object to be created", required = true, schema = @Schema()) @Valid @RequestBody Screening body) {
        try {
            screeningDao.addScreening(body);

            return new ResponseEntity<>(body, HttpStatus.CREATED);
        } catch (DataAccessException e) {
            log.error(e.getMessage());
        }

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

}
