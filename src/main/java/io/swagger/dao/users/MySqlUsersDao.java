package io.swagger.dao.users;

import io.swagger.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.IncorrectResultSetColumnCountException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class MySqlUsersDao implements UsersDao {

    private final String usersTableName;

    private final JdbcTemplate jdbcTemplate;

    public MySqlUsersDao(JdbcTemplate jdbcTemplate, String usersTableName) {
        this.jdbcTemplate = jdbcTemplate;
        this.usersTableName = usersTableName;
    }

    @Override
    public String addUser(User user) throws SQLIntegrityConstraintViolationException {
        String query = "INSERT INTO " + usersTableName + " (email, join_date) VALUES (?, ?)";
        try {
            int affectedRows = jdbcTemplate.update(query, user.getEmail(), user.getJoinDate().toString());
            return affectedRows > 0 ? user.getEmail() : null;
        } catch (DataAccessException e) {
            if (e instanceof org.springframework.dao.DuplicateKeyException) {
                throw new SQLIntegrityConstraintViolationException();
            }
        }

        return null;
    }

    @Override
    public User getUserById(String id) {
        String query = "SELECT * FROM " + usersTableName + " WHERE email = \"" + id + "\";";
        User user;
        try {
            user = jdbcTemplate.queryForObject(query, UsersDaoUtils::mapToUser);
        } catch (IncorrectResultSetColumnCountException e) {
            user = null;
        }

        return user;
    }

    @Override
    public boolean deleteUserById(String id) {
        String query = "DELETE FROM " + usersTableName + " WHERE email = \"" + id + "\"";
        return jdbcTemplate.update(query) > 0;
    }

    @Override
    public List<User> getAllUsers() {
        String query = "SELECT * FROM " + usersTableName;
        return jdbcTemplate.query(query, UsersDaoUtils::mapToUsers);
    }

    @Override
    public boolean updateUserById(User user, String id) throws SQLIntegrityConstraintViolationException {
        String query = "UPDATE " + usersTableName + " SET email = ?, join_date = ? WHERE email = \"" + id + "\"";
        try {
            int rowsAffected = jdbcTemplate.update(query, user.getEmail(), user.getJoinDate().toString());

            return rowsAffected > 0;
        } catch (DataAccessException e) {
            if (e instanceof org.springframework.dao.DuplicateKeyException) {
                throw new SQLIntegrityConstraintViolationException();
            }
        }

        return false;
    }
}
