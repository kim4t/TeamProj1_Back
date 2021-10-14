package bfs.TeamProj.controller;

import bfs.TeamProj.Service.RegisterService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("login")
@Data
public class RegisterController {
    @Autowired
    RegisterService registerService;

    @PostMapping("/register")
    public String register(HttpServletRequest httpServletRequest){
        return registerService.register(httpServletRequest);
    }
}
