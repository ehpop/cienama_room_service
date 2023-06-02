package io.swagger.dao.users;

import io.swagger.model.User;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class MySqlUsersDao implements UsersDao {

    private final String usersTableName;

    private final JdbcTemplate jdbcTemplate;

    public MySqlUsersDao(JdbcTemplate jdbcTemplate, String usersTableName) {
        this.jdbcTemplate = jdbcTemplate;
        this.usersTableName = usersTableName;
    }

    @Override
    public Integer addUser(User user) {
        return null;
    }

    @Override
    public User getUserById(Integer id) {
        return null;
    }

    @Override
    public boolean deleteUserById(Integer id) {
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public boolean updateUserById(User user, Integer id) {
        return false;
    }
}
