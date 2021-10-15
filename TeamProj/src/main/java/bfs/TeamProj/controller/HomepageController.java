package bfs.TeamProj.controller;

import bfs.TeamProj.Service.HomePageService;
import bfs.TeamProj.constant.Constant;
import bfs.TeamProj.domain.PersonalInformation;
import bfs.TeamProj.domain.User;
import bfs.TeamProj.security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/employee/homePage")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", allowCredentials = "true")
public class HomepageController {
    @Autowired
    private HomePageService homePageService;

    @GetMapping
    public PersonalInformation userInfo(HttpServletRequest request){
        String username = JwtUtil.getSubject(request, Constant.JWT_TOKEN_COOKIE_NAME, Constant.SIGNING_KEY);
        System.out.println(username);
        if(username == null) {
            return null;
        }
        return homePageService.assemble(username);
    }
}
