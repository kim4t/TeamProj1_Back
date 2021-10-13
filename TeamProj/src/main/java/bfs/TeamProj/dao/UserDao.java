package bfs.TeamProj.dao;

import bfs.TeamProj.domain.User;

public interface UserDao {
    User getUserById(int id);

    User getUserByEmail(String email);

    Integer addUser(User user);
}
