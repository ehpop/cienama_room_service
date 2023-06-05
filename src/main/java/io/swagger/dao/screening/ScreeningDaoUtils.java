package io.swagger.dao.screening;

import io.swagger.model.Screening;
import org.threeten.bp.OffsetDateTime;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScreeningDaoUtils {

    public static Screening mapToScreeningWithoutId(ResultSet rs) throws SQLException {
        Screening screening = new Screening();
        screening.setMovie(rs.getInt("movie_id"));
        screening.setRoom(rs.getInt("room_id"));
        screening.setStartTime(OffsetDateTime.parse(rs.getString("start_time")));
        screening.setEndTime(OffsetDateTime.parse(rs.getString("end_time")));
        screening.setTicketPrice(rs.getDouble("ticket_price"));
        return screening;
    }

    public static Screening mapToScreening(ResultSet rs, Integer id) throws SQLException {
        Screening screening = mapToScreeningWithoutId(rs);
        screening.setId(id);

        return screening;
    }

    public static List<Screening> mapScreenings(ResultSet rs) throws SQLException {
        List<Screening> list = new ArrayList<>();
        while (rs.next()) {
            Screening screening = mapToScreeningWithoutId(rs);

            list.add(screening);
        }

        return list;
    }

}
