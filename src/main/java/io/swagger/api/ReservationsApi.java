/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.41).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Reservation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-03-31T21:52:24.625697542Z[GMT]")
@Validated
public interface ReservationsApi {

    @Operation(summary = "Get all reservations", description = "", tags={ "Reservations" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Reservation.class)))),
        
        @ApiResponse(responseCode = "400", description = "Invalid input") })
    @RequestMapping(value = "/reservations",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Reservation>> reservationsGet(@NotNull @Parameter(in = ParameterIn.QUERY, description = "User to retrieve reservations for" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "user", required = true) String user);


    @Operation(summary = "Delete a reservation by ID", description = "", tags={ "Reservations" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Reservation deleted successfully"),
        
        @ApiResponse(responseCode = "404", description = "Reservation not found") })
    @RequestMapping(value = "/reservations/{id}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> reservationsIdDelete(@Parameter(in = ParameterIn.PATH, description = "ID of the reservation to delete", required=true, schema=@Schema()) @PathVariable("id") Integer id);


    @Operation(summary = "Get a reservation by ID", description = "", tags={ "Reservations" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Reservation retrieved successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Reservation.class))),
        
        @ApiResponse(responseCode = "404", description = "Reservation not found") })
    @RequestMapping(value = "/reservations/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Reservation> reservationsIdGet(@Parameter(in = ParameterIn.PATH, description = "ID of the reservation to retrieve", required=true, schema=@Schema()) @PathVariable("id") Integer id);


    @Operation(summary = "Update a reservation by ID", description = "", tags={ "Reservations" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Reservation updated successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Reservation.class))),
        
        @ApiResponse(responseCode = "404", description = "Reservation not found") })
    @RequestMapping(value = "/reservations/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Reservation> reservationsIdPut(@Parameter(in = ParameterIn.PATH, description = "ID of the reservation to update", required=true, schema=@Schema()) @PathVariable("id") Integer id, @Parameter(in = ParameterIn.DEFAULT, description = "Reservation object to update", required=true, schema=@Schema()) @Valid @RequestBody Reservation body);

}

