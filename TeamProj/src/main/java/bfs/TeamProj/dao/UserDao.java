package bfs.TeamProj.dao;

import bfs.TeamProj.domain.User;

public interface UserDao {
    User getUserById(int id);

    Integer addUser(User user);
}
