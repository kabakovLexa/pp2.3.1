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
    public void addUser(User user) {


        entityManager.persist(user);


    }
    @Override
    public User getUserId(int id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public List<User> allUsers() {
        List<User> userList = new ArrayList<>();
        userList = entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
        return userList;

    }


}
