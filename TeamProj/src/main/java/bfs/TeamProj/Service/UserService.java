package bfs.TeamProj.Service;

import bfs.TeamProj.dao.PersonDao;
import bfs.TeamProj.dao.RoleDao;
import bfs.TeamProj.dao.UserDao;
import bfs.TeamProj.dao.UserRoleDao;
import bfs.TeamProj.domain.Person;
import bfs.TeamProj.domain.Role;
import bfs.TeamProj.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRoleDao userRoleDao;
    @Autowired
    private RoleDao roleDao;


    @Transactional
    public User addUser(User user) {
        return userDao.addUser(user);
    }

    @Transactional
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Transactional
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Transactional
    public User getUserByUserName(String userName) {
        return userDao.getUserByUserName(userName);
    }

    @Transactional
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Transactional
    public boolean isAdminUser(String userName){
        User user = getUserByUserName(userName);
        //Role role = userRoleDao.
        return true;
    }
}
