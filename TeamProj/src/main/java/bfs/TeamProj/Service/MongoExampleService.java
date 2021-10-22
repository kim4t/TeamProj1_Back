package bfs.TeamProj.Service;

import bfs.TeamProj.dao.MongoRepositoryExample;
import bfs.TeamProj.domain.Owner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoExampleService {
    private MongoRepositoryExample repository;

    public MongoExampleService(MongoRepositoryExample repository) {
        this.repository = repository;
    }

    public Owner findUserByUsername(String username) {
        return repository.findUserByUsername(username).get(0);
    }

    public void saveOrUpdateUser(Owner owner) {
        repository.save(owner);
    }

    public List<Owner> findUserByPassword(String password) {
        return repository.findUserByPassword(password);
    }
}