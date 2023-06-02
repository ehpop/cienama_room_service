package io.swagger.dao.complaints;

import io.swagger.model.Complaint;

import java.util.List;

public interface ComplaintsDao {
    public Integer addComplaint(Complaint complaint);

    public  Complaint getComplaintById(Integer id);

    public boolean deleteComplaintById(Integer id);

    public List<Complaint> getAllComplaints();

    public boolean updateComplaintById(Complaint complaint, Integer id);
}
