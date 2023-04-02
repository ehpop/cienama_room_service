package io.swagger.dao.screening;

import io.swagger.model.Screening;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

public class MySqlScreeningDao implements ScreeningDao{

    private final JdbcTemplate jdbcTemplate;
    private final String screeningTableName;

    public MySqlScreeningDao(JdbcTemplate jdbcTemplate, String screeningTableName){
        this.jdbcTemplate = jdbcTemplate;
        this.screeningTableName = screeningTableName;
    }
    @Override
    public Integer addScreening(Screening screening) {
        String query = "INSERT INTO " + screeningTableName + "(start_time, end_time, room_id, movie_id) VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, screening.getStartTime().toString());
            ps.setString(2, screening.getEndTime().toString());
            ps.setInt(3, screening.getRoom());
            ps.setInt(4, screening.getMovie());
            return ps;
        }, keyHolder);

        screening.setId(Objects.requireNonNull(keyHolder.getKey()).intValue());

        return screening.getId();
    }

    @Override
    public Screening getScreeningById(Integer id) {
        String query = "SELECT * FROM " + screeningTableName + " WHERE id = " + id;
        Screening screening = jdbcTemplate.queryForObject(query, ScreeningDaoUtils::mapToScreening);

        if (screening != null) {
            screening.setId(id);
        }

        return screening;
    }

    @Override
    public boolean deleteScreeningById(Integer id) {
        int rowsAffected = 0;
        String query = "DELETE FROM " + screeningTableName + " where id = " + id;

        try {
            rowsAffected += jdbcTemplate.update(query);
        } catch (EmptyResultDataAccessException e){
            return false;
        }

        return rowsAffected > 0;
    }

    @Override
    public List<Screening> getAllScreenings() {
        String query = "SELECT * FROM " + screeningTableName;

        return jdbcTemplate.query(query, ScreeningDaoUtils::mapScreenings);
    }

    @Override
    public boolean updateScreeningById(Screening screening, Integer id) {
        String query = "UPDATE " + screeningTableName + " SET start_time = ?, end_time = ?, room_id = ?, movie_id = ? WHERE id = " + id;

        int rowsAffected = jdbcTemplate.update(query, screening.getStartTime().toString(), screening.getEndTime().toString(), screening.getRoom(), screening.getMovie());
        screening.setId(id);

        return rowsAffected > 0;
    }
}
