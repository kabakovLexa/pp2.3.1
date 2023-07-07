package web.Service;

import web.Model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    User getUser(int id);

    void updateUser(int id, User user);

    List<User> getAllUsers();

    void deleteUser(int id);
}
