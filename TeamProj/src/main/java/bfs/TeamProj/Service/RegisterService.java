package bfs.TeamProj.Service;

import bfs.TeamProj.domain.User;
import bfs.TeamProj.request.RegisterRequest;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Data
public class RegisterService {
    @Autowired
    private final UserService userService;

    public String register(RegisterRequest registerRequest){
       User u = new User();
       u.setUserName(registerRequest.getUserName());
       u.setPassword(registerRequest.getPassword());
       u.setEmail(registerRequest.getEmail());
       u.setCreateDate(LocalDate.now());
       u.setModificationDate(LocalDate.now());
       if(userService.getUserByEmail(registerRequest.getEmail())==null){
           userService.addUser(u);
           return "works";
       }
        return "Already Exist";
    }
}
