package web.Dao;

import web.Model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    User getUser(int id);
    void updateUser(int id, User user);
    List<User> getAllUsers();
    void dropUserById(int id);
}
