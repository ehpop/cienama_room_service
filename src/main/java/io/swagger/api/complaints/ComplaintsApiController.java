package io.swagger.api.complaints;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.dao.complaints.ComplaintsDao;
import io.swagger.model.Complaint;
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
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-01T22:20:35.081630147Z[GMT]")
@RestController
public class ComplaintsApiController implements ComplaintsApi {

    private static final Logger log = LoggerFactory.getLogger(ComplaintsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final ComplaintsDao complaintsDao;

    @org.springframework.beans.factory.annotation.Autowired
    public ComplaintsApiController(ObjectMapper objectMapper, HttpServletRequest request, ComplaintsDao complaintsDao) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.complaintsDao = complaintsDao;
    }

    public ResponseEntity<List<Complaint>> complaintsGet() {
        List<Complaint> complaints = complaintsDao.getAllComplaints();

        return new ResponseEntity<List<Complaint>>(complaints, HttpStatus.OK);
    }

    public ResponseEntity<Void> complaintsIdDelete(
            @Parameter(in = ParameterIn.PATH, description = "ID of the Complaint to delete", required = true, schema = @Schema()) @PathVariable("id") Integer id) {
        try {
            boolean deleted = complaintsDao.deleteComplaintById(id);
            if (deleted) {
                return new ResponseEntity<Void>(HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Complaint> complaintsIdGet(
            @Parameter(in = ParameterIn.PATH, description = "ID of the Complaint to retrieve", required = true, schema = @Schema()) @PathVariable("id") Integer id) {
        try {
            Complaint complaint = complaintsDao.getComplaintById(id);
            System.out.println(complaint);
            if (complaint != null) {
                return new ResponseEntity<Complaint>(complaint, HttpStatus.OK);
            } else {
                return new ResponseEntity<Complaint>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<Complaint>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Complaint> complaintsIdPut(
            @Parameter(in = ParameterIn.PATH, description = "ID of the Complaint to update", required = true, schema = @Schema()) @PathVariable("id") Integer id,
            @Parameter(in = ParameterIn.DEFAULT, description = "Complaint object to update", required = true, schema = @Schema()) @Valid @RequestBody Complaint body) {
        try {
            boolean updated = complaintsDao.updateComplaintById(body, id);
            if (updated) {
                return new ResponseEntity<Complaint>(body, HttpStatus.OK);
            } else {
                return new ResponseEntity<Complaint>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<Complaint>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Complaint> complaintsPost(
            @Parameter(in = ParameterIn.DEFAULT, description = "Complaint object to be created", required = true, schema = @Schema()) @Valid @RequestBody Complaint body) {
        try {
            Integer newComplainId = complaintsDao.addComplaint(body);
        } catch (Exception e) {
            return new ResponseEntity<Complaint>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Complaint>(body, HttpStatus.CREATED);
    }

}
