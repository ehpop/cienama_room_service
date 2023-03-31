package io.swagger.api;

import io.swagger.dao.room.RoomDao;
import io.swagger.model.Room;
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

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-03-31T21:52:24.625697542Z[GMT]")
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
        ArrayList<Room> rooms = roomDao.getAllRooms();

        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    public ResponseEntity<Void> roomsIdDelete(@Min(1)@Parameter(in = ParameterIn.PATH, description = "ID of the room to delete", required=true, schema=@Schema(allowableValues={ "1" }, minimum="1"
)) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Room> roomsIdGet(@Min(1)@Parameter(in = ParameterIn.PATH, description = "ID of the room to get", required=true, schema=@Schema(allowableValues={ "1" }, minimum="1"
)) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Room>(objectMapper.readValue("{\n  \"movies\" : [ 1, 1 ],\n  \"name\" : \"name\",\n  \"id\" : 0,\n  \"capacity\" : 6\n}", Room.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Room>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Room>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Room> roomsIdPut(@Min(1)@Parameter(in = ParameterIn.PATH, description = "ID of the room to update", required=true, schema=@Schema(allowableValues={ "1" }, minimum="1"
)) @PathVariable("id") Integer id,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Room body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Room>(objectMapper.readValue("{\n  \"movies\" : [ 1, 1 ],\n  \"name\" : \"name\",\n  \"id\" : 0,\n  \"capacity\" : 6\n}", Room.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Room>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Room>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Room> roomsPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Room body) {
        try {
            int idOfTheRoom = roomDao.addRoom(body);
            body.setId(idOfTheRoom);
            return new ResponseEntity<Room>(body, HttpStatus.CREATED);

        } catch (DataAccessException e) {
            log.error(e.getMessage());
            System.err.println(e.getMessage());
        }

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

}
