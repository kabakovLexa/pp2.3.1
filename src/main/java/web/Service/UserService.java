package web.Service;


import web.Model.User;

import java.util.List;

public interface UserService {

    public List<User> allUsers();
    public User getUserId(int id);
    public void addUser(User user);

}
