package bfs.TeamProj.config;

import bfs.TeamProj.Service.MongoExampleService;
import bfs.TeamProj.dao.MongoRepositoryExample;
import bfs.TeamProj.domain.Owner;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@Api(value = "Rest endpoints")
public class MongoExampleController {

    private final MongoExampleService service;

    @Autowired
    public MongoExampleController(MongoExampleService service) {
        this.service = service;
    }

    @GetMapping(value = "/owner", params = "username")
    @ApiOperation(value = "Find user by the username", response = Owner.class)
    public Owner findUserByUsername(@RequestParam String username) {
        return service.findUserByUsername(username);
    }

    @PostMapping("/owner")
    @ApiOperation(value = "Save or update the user")
    public void saveOrUpdateUser(@RequestBody Owner user) {
        service.saveOrUpdateUser(user);
    }

    @GetMapping(value = "/owner-password", params = "password")
    @ApiOperation(value = "Find user by the password", response = Iterable.class)
    public List<Owner> findUserByPassword(String password) {
        return service.findUserByPassword(password);
    }

}
