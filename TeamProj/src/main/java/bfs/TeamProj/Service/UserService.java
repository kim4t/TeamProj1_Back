package bfs.TeamProj.Service;

import bfs.TeamProj.dao.PersonDao;
import bfs.TeamProj.dao.UserDao;
import bfs.TeamProj.domain.Person;
import bfs.TeamProj.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private PersonDao personDao;

    @Transactional
    public Integer addUser(User user, int personId) {
        return userDao.addUser(user);
    }

    @Transactional
    public Integer addUser(User user) {
        return userDao.addUser(user);
    }

    @Transactional
    public User getUserById(int id) {
        User u = userDao.getUserById(id);
        return u;
    }

    @Transactional
    public User getUserByEmail(String email) {
        User u = userDao.getUserByEmail(email);
        return u;
    }
}
