package bfs.TeamProj.dao;

import bfs.TeamProj.domain.Owner;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MongoRepositoryExample extends MongoRepository<Owner, String> {
    List<Owner> findUserByUsername(String username);

    @Query(value = "{password: ?0}", fields = "{id: 0, username: 1, password: 1}")
    List<Owner> findUserByPassword(String password);
}

