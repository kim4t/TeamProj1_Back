package bfs.TeamProj.dao;

import bfs.TeamProj.domain.User;

public interface UserDao {
    User getUserById(int id);

    User getUserByEmail(String email);

    User addUser(User user);

    User updateUser(User user);
}
