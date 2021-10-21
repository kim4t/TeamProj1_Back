package bfs.TeamProj.controller;

import bfs.TeamProj.Service.EmailSenderService;
import bfs.TeamProj.Service.UserService;
import bfs.TeamProj.domain.User;
import bfs.TeamProj.domain.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/HR/email")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", allowCredentials = "true")
public class EmailController {
    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private UserService userService;

    private int Id;

    @PostMapping
    public String getEmail(HttpServletRequest httpServletRequest){
        System.out.println(httpServletRequest.getParameter("e-mail"));
        triggerMail(httpServletRequest.getParameter("e-mail"));

        UserResponse userResponse = UserResponse.builder().userList(userService.findAll()).build();
        //return new ResponseEntity<>(userResponse, HttpStatus.OK);

        return "work";
    }

    public void triggerMail(String email){
        emailSenderService.sendSimpleEmail(email);
    }
}
