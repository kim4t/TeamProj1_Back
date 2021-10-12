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
        return userDao.addUser(user, personId);
    }

    @Transactional
    public Integer addUser(User user) {
        int personId = user.getPerson().getId();
        return userDao.addUser(user, personId);
    }
    @Transactional
    public User getUserById(int id) {
        User u = userDao.getUserById(id);
        u.setPerson(personDao.getPersonById(u.getPerson().getId()));
        return u;
    }
}
