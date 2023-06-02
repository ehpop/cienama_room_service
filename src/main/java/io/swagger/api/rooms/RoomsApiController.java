package io.swagger.api.rooms;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.dao.room.RoomDao;
import io.swagger.model.Room;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-04-01T09:19:04.215466341Z[GMT]")
@RestController
public class RoomsApiController implements RoomsApi {

    private static final Logger log = LoggerFactory.getLogger(RoomsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final RoomDao roomDao;

    @org.springframework.beans.factory.annotation.Autowired
    public RoomsApiController(ObjectMapper objectMapper, HttpServletRequest request, RoomDao roomDao) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.roomDao = roomDao;
    }

    public ResponseEntity<List<Room>> roomsGet() {
        List<Room> rooms = roomDao.getAllRooms();

        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    public ResponseEntity<Void> roomsIdDelete(@Min(1)@Parameter(in = ParameterIn.PATH, description = "ID of the room to delete", required=true, schema=@Schema(allowableValues={ "1" }, minimum="1"
)) @PathVariable("id") Integer id) {
        try {
            roomDao.deleteRoomById(id);
        } catch (EmptyResultDataAccessException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Room> roomsIdGet(@Min(1)@Parameter(in = ParameterIn.PATH, description = "ID of the room to get", required=true, schema=@Schema(allowableValues={ "1" }, minimum="1"
)) @PathVariable("id") Integer id) {
        try {
            Room room = roomDao.getRoomById(id);
            return new ResponseEntity<>(room, HttpStatus.OK);
        } catch (EmptyResultDataAccessException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Room> roomsIdPut(@Min(1)@Parameter(in = ParameterIn.PATH, description = "ID of the room to update", required=true, schema=@Schema(allowableValues={ "1" }, minimum="1"
)) @PathVariable("id") Integer id,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Room body) {
        try {
            roomDao.updateRoomById(body, id);
            return new ResponseEntity<>(body, HttpStatus.OK);
        } catch (DataAccessException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(body, HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<Room> roomsPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Room body) {
        try {
            int idOfTheRoom = roomDao.addRoom(body);
            body.setId(idOfTheRoom);
            return new ResponseEntity<Room>(body, HttpStatus.CREATED);

        } catch (DataAccessException e) {
            log.error(e.getMessage());
        }

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

}
