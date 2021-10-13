package bfs.TeamProj.controller;

import bfs.TeamProj.Service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/HR/email")
@CrossOrigin(origins = "http://localhost:4200")
public class EmailController {
    @Autowired
    private EmailSenderService emailSenderService;

    @PostMapping
    public String getEmail(HttpServletRequest httpServletRequest){
        System.out.println(httpServletRequest.getParameter("e-mail"));
        triggerMail(httpServletRequest.getParameter("e-mail"));

        return "work";
    }

    public void triggerMail(String email){
        emailSenderService.sendSimpleEmail(email);
    }
}
