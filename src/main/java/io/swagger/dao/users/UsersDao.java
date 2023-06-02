package io.swagger.dao.users;

import io.swagger.model.User;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public interface UsersDao {
    public String addUser(User user) throws SQLIntegrityConstraintViolationException;

    public User getUserById(String id);

    public boolean deleteUserById(String id);

    public List<User> getAllUsers();

    public boolean updateUserById(User user, String id) throws SQLIntegrityConstraintViolationException;
}
