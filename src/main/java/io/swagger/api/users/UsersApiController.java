package io.swagger.api.users;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.dao.users.UsersDao;
import io.swagger.model.User;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-01T22:20:35.081630147Z[GMT]")
@RestController
public class UsersApiController implements UsersApi {

    private static final Logger log = LoggerFactory.getLogger(UsersApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final UsersDao usersDao;

    @org.springframework.beans.factory.annotation.Autowired
    public UsersApiController(ObjectMapper objectMapper, HttpServletRequest request, UsersDao usersDao) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.usersDao = usersDao;
    }

    public ResponseEntity<List<User>> usersGet() {
        try {
            List<User> users = usersDao.getAllUsers();
            return new ResponseEntity<List<User>>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<User>>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Void> usersIdDelete(
            @Parameter(in = ParameterIn.PATH, description = "ID of the user to delete", required = true, schema = @Schema()) @PathVariable("id") String id) {
        try {
            boolean deleted = usersDao.deleteUserById(id);
            if (deleted) {
                return new ResponseEntity<Void>(HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<User> usersIdGet(
            @Parameter(in = ParameterIn.PATH, description = "ID of the user to retrieve", required = true, schema = @Schema()) @PathVariable("id") String id) {
        try {
            User user = usersDao.getUserById(id);
            if (user == null) {
                return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<User> usersIdPut(
            @Parameter(in = ParameterIn.PATH, description = "ID of the user to update", required = true, schema = @Schema()) @PathVariable("id") String id,
            @Parameter(in = ParameterIn.DEFAULT, description = "User object to update", required = true, schema = @Schema()) @Valid @RequestBody User body) {
        try {
            boolean updated = usersDao.updateUserById(body, id);
            if (updated) {
                return new ResponseEntity<User>(HttpStatus.OK);
            } else {
                return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
            }
        } catch (SQLIntegrityConstraintViolationException duplicateError) {
            return new ResponseEntity<User>(HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<User> usersPost(
            @Parameter(in = ParameterIn.DEFAULT, description = "User object to be created", required = true, schema = @Schema()) @Valid @RequestBody User body) {
        try {
            usersDao.addUser(body);
            return new ResponseEntity<User>(HttpStatus.OK);
        } catch (SQLIntegrityConstraintViolationException duplicateError) {
            return new ResponseEntity<User>(HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
    }

}
