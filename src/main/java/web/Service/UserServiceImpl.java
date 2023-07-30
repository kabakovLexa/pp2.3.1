package web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.Dao.UserDAO;
import web.Model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void addUser(String name, String surname, int salary) {
        userDAO.addUser(name, surname, salary);

    }

    @Override
    public List<User> allUsers() {
        return userDAO.allUsers();
    }
}
