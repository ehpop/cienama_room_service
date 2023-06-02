package io.swagger.dao.complaints;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.threeten.bp.OffsetDateTime;

import io.swagger.model.Complaint;

public class ComplaintsDaoUtils {
    public static Complaint mapToComplaint(ResultSet resultSet, Integer id) throws SQLException {
        Complaint complaint = new Complaint();
        complaint.setId(id);
        complaint.setIssueDate(OffsetDateTime.parse(resultSet.getString("issue_date")));
        complaint.setUserId(resultSet.getString("user_id"));
        complaint.setResponseContact(resultSet.getString("response_contact"));
        complaint.setStatus(Complaint.StatusEnum.valueOf(resultSet.getString("status").toUpperCase()));
        complaint.setComplaintMsg(resultSet.getString("complaint_msg"));

        return complaint;
    }

    public static List<Complaint> mapToComplaints(ResultSet resultSet) throws SQLException {
        List<Complaint> complaints = new ArrayList<>();

        while (resultSet.next()) {
            Complaint complaint = new Complaint();
            complaint.setId(resultSet.getInt("id"));
            complaint.setIssueDate(OffsetDateTime.parse(resultSet.getString("issue_date")));
            complaint.setUserId(resultSet.getString("user_id"));
            complaint.setResponseContact(resultSet.getString("response_contact"));
            complaint.setStatus(Complaint.StatusEnum.valueOf(resultSet.getString("status").toUpperCase()));
            complaint.setComplaintMsg(resultSet.getString("complaint_msg"));

            complaints.add(complaint);
        }

        return complaints;
    }
}
