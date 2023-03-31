package io.swagger.DAO.Screening;

import io.swagger.model.Screening;

import java.util.ArrayList;

public interface ScreeningDao {
    public Integer addScreening(Screening screening);

    public Screening getScreeningById(Integer id);

    public boolean deleteScreeningById(Integer id);

    public ArrayList<Screening> getAllScreenings();

    public boolean updateScreeningById(Integer id);
}
