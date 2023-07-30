package web.Dao;

import web.Model.User;

import java.util.List;

public interface UserDAO {
    public void addUser(String name, String surname, int salary);
    public List<User> allUsers();
}
