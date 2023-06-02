package io.swagger.dao.users;

import io.swagger.model.User;
import org.threeten.bp.OffsetDateTime;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoUtils {
    public static User mapToUser(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setEmail(resultSet.getString("email"));
        user.setJoinDate(OffsetDateTime.parse(resultSet.getString("join_date")));
        return user;
    }

    public static List<User> mapToUsers(ResultSet resultSet) throws SQLException {
        List<User> list = new ArrayList<>();
        while (resultSet.next()) {
            User user = new User();
            user.setEmail(resultSet.getString("email"));
            user.setJoinDate(OffsetDateTime.parse(resultSet.getString("join_date")));

            list.add(user);
        }

        return list;
    }
}
