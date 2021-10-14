package bfs.TeamProj.Service;

import bfs.TeamProj.domain.RegistrationToken;
import bfs.TeamProj.domain.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
public class RegisterService {

    private final UserService userService;
    private final RegistrationTokenService tokenService;

    @Autowired
    public RegisterService(UserService userService, RegistrationTokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }

    public String register(HttpServletRequest httpServletRequest){

        // TODO: check whether token is valid
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println(httpServletRequest.getParameter("token"));
        Optional<RegistrationToken> token = tokenService.getAllToken().stream().
                filter(t -> t.getToken().equalsIgnoreCase(httpServletRequest.getParameter("token"))).findAny();
        if(!token.isPresent()){
            System.out.println("Invalid Token");
            return "Invalid Token";
        }
        else if(token.get().getValidDuration().isBefore(currentTime)){
            System.out.println("Token has been expired");
            return "Expired Token";
        }
        // TODO: check whether user already exist
        Optional<User> u = Optional.ofNullable(userService.getUserByEmail(httpServletRequest.getParameter("email")));
        if(u.isPresent()){
            System.out.println("User with this email already exist");
            return "Exist User";
        }

        //else
        User newUser = new User();
        newUser.setUserName(httpServletRequest.getParameter("userName"));
        newUser.setPassword(httpServletRequest.getParameter("password"));
        newUser.setEmail(httpServletRequest.getParameter("email"));
        newUser.setCreateDate(LocalDate.now());
        newUser.setModificationDate(LocalDate.now());
        userService.addUser(newUser);
        return "Succeed";
    }
}
