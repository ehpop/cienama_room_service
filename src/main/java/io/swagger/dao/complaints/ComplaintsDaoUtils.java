package io.swagger.dao.complaints;

import io.swagger.model.Complaint;
import org.threeten.bp.OffsetDateTime;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComplaintsDaoUtils {
    public static Complaint mapToComplaintWithoutId(ResultSet resultSet) throws SQLException {
        Complaint complaint = new Complaint();
        complaint.setId(resultSet.getInt("id"));
        complaint.setIssueDate(OffsetDateTime.parse(resultSet.getString("issue_date")));
        complaint.setUserId(resultSet.getString("user_id"));
        complaint.setResponseContact(resultSet.getString("response_contact"));
        complaint.setStatus(Complaint.StatusEnum.valueOf(resultSet.getString("status").toUpperCase()));
        complaint.setComplaintMsg(resultSet.getString("complaint_msg"));

        return complaint;
    }

    public static Complaint mapToComplaint(ResultSet resultSet, Integer id) throws SQLException {
        Complaint complaint = mapToComplaintWithoutId(resultSet);
        complaint.setId(id);

        return complaint;
    }

    public static List<Complaint> mapToComplaints(ResultSet resultSet) throws SQLException {
        List<Complaint> complaints = new ArrayList<>();

        while (resultSet.next()) {
            Complaint complaint = mapToComplaintWithoutId(resultSet);
            complaints.add(complaint);
        }

        return complaints;
    }
}
