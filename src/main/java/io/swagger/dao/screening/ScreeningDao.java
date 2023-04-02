package io.swagger.dao.screening;

import io.swagger.model.Screening;

import java.util.List;

public interface ScreeningDao {
    public Integer addScreening(Screening screening);

    public Screening getScreeningById(Integer id);

    public boolean deleteScreeningById(Integer id);

    public List<Screening> getAllScreenings();

    public boolean updateScreeningById(Screening screening, Integer id);
}
