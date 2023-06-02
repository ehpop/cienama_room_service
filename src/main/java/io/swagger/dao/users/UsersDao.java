package io.swagger.dao.users;

import io.swagger.model.User;

import java.util.List;

public interface UsersDao {
    public Integer addUser(User user);

    public  User getUserById(Integer id);

    public boolean deleteUserById(Integer id);

    public List<User> getAllUsers();

    public boolean updateUserById(User user, Integer id);
}
