package io.swagger.dao.screening;

import io.swagger.model.Screening;
import org.threeten.bp.OffsetDateTime;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScreeningDaoUtils {

    public static Screening mapToScreening(ResultSet rs, Integer id) throws SQLException {
        Screening screening = new Screening();
        screening.setId(id);
        screening.setMovie(rs.getInt("movie_id"));
        screening.setRoom(rs.getInt("room_id"));
        screening.setStartTime(OffsetDateTime.parse(rs.getString("start_time")));
        screening.setEndTime(OffsetDateTime.parse(rs.getString("end_time")));
        return screening;
    }

    public static List<Screening> mapScreenings(ResultSet rs) throws SQLException {
        List<Screening> list = new ArrayList<>();
        while(rs.next()){
            Screening screening = new Screening();
            screening.setId(rs.getInt("id"));
            screening.setStartTime(OffsetDateTime.parse(rs.getString("start_time")));
            screening.setEndTime(OffsetDateTime.parse(rs.getString("end_time")));
            screening.setRoom(rs.getInt("room_id"));
            screening.setMovie(rs.getInt("movie_id"));

            list.add(screening);
        }

        return list;
    }

}
