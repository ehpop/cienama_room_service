package io.swagger.dao.complaints;

import io.swagger.model.Complaint;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

public class MySqlComplaintsDao implements ComplaintsDao {
    private final String complaintsTableName;

    private final JdbcTemplate jdbcTemplate;

    public MySqlComplaintsDao(JdbcTemplate jdbcTemplate, String complaintsTableName) {
        this.jdbcTemplate = jdbcTemplate;
        this.complaintsTableName = complaintsTableName;
    }

    @Override
    public Integer addComplaint(Complaint complaint) {
        String query = "INSERT INTO " + complaintsTableName
                + " (issue_date, user_id, response_contact, status, complaint_msg) VALUES (?, ?, ?, ?, ?)";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, complaint.getIssueDate().toString());
            ps.setString(2, complaint.getUserId());
            ps.setString(3, complaint.getResponseContact());
            ps.setString(4, complaint.getStatus().toString());
            ps.setString(5, complaint.getComplaintMsg());
            return ps;
        }, keyHolder);

        int complaintID = Objects.requireNonNull(keyHolder.getKey()).intValue();

        complaint.setId(complaintID);

        return complaintID;
    }

    @Override
    public Complaint getComplaintById(Integer id) {
        String query = "SELECT * FROM " + complaintsTableName + " WHERE id = " + id;

        try {
            return jdbcTemplate.queryForObject(query, ComplaintsDaoUtils::mapToComplaint);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }

    }

    @Override
    public boolean deleteComplaintById(Integer id) {
        String query = "DELETE FROM " + complaintsTableName + " WHERE id = " + id;
        int rowsAffected;
        try {
            rowsAffected = jdbcTemplate.update(query);
        } catch (EmptyResultDataAccessException e) {
            return false;
        }

        return rowsAffected == 1;
    }

    @Override
    public List<Complaint> getAllComplaints() {
        String query = "SELECT * FROM " + complaintsTableName;

        return jdbcTemplate.query(query, ComplaintsDaoUtils::mapToComplaints);
    }

    @Override
    public boolean updateComplaintById(Complaint complaint, Integer id) {
        String query = "UPDATE " + complaintsTableName
                + " SET issue_date = ?, user_id = ?, response_contact = ?, status = ?, complaint_msg = ? WHERE id = "
                + id;

        int rowsAffected = jdbcTemplate.update(query, complaint.getIssueDate().toString(), complaint.getUserId(),
                complaint.getResponseContact(), complaint.getStatus().toString(), complaint.getComplaintMsg());
        complaint.setId(id);

        return rowsAffected == 1;
    }
}
