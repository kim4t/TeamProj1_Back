package bfs.TeamProj.Service;

import bfs.TeamProj.domain.User;
import bfs.TeamProj.request.RegisterRequest;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class RegisterService {
    @Autowired
    private final PersonService personService;

    public String register(RegisterRequest registerRequest){
       User u = new User();

        return "works";
    }
}
