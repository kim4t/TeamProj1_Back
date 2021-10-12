package bfs.TeamProj.controller;

import bfs.TeamProj.Service.RegisterService;
import bfs.TeamProj.request.RegisterRequest;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/registration")
@Data
public class RegisterController {
    @Autowired
    RegisterService registerService;

    public String register(@RequestBody RegisterRequest registrationRequest){

        return registerService.register(registrationRequest);
    }
}
