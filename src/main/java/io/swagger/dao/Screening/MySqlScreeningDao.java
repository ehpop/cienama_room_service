package io.swagger.DAO.Screening;

import io.swagger.model.Screening;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;

public class MySqlScreeningDao implements ScreeningDao{

    private final JdbcTemplate jdbcTemplate;
    private final String screeningTableName;

    public MySqlScreeningDao(JdbcTemplate jdbcTemplate, String screeningTableName){
        this.jdbcTemplate = jdbcTemplate;
        this.screeningTableName = screeningTableName;
    }
    @Override
    public Integer addScreening(Screening screening) {
        return null;
    }

    @Override
    public Screening getScreeningById(Integer id) {
        return null;
    }

    @Override
    public boolean deleteScreeningById(Integer id) {
        return false;
    }

    @Override
    public ArrayList<Screening> getAllScreenings() {
        return null;
    }

    @Override
    public boolean updateScreeningById(Integer id) {
        return false;
    }
}
