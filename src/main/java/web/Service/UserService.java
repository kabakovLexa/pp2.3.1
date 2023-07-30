package web.Service;


import web.Model.User;

import java.util.List;

public interface UserService {
    public void addUser(String name, String surname, int salary);
    public List<User> allUsers();

}
