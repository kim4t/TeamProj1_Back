package bfs.TeamProj.dao;

import bfs.TeamProj.domain.User;

import java.util.List;

public interface UserDao {
    User getUserById(int id);

    User getUserByEmail(String email);

    User getUserByUserName(String userName);

    User addUser(User user);

    User updateUser(User user);

    List<User> findAll();
}
