package web.Dao;

import web.Model.User;

import java.util.List;

public interface UserDAO {

    public List<User> allUsers();
    public User getUserId(int id);
    public void addUser(User user);
}
