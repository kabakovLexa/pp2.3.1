package web.Dao;

import org.springframework.stereotype.Repository;
import web.Model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(String name, String surname, int salary) {


        User user = new User(name,surname,salary);
        entityManager.persist(user);


    }

    @Override
    public List<User> allUsers() {
        List<User> userList = new ArrayList<>();
        return userList;

    }


}
