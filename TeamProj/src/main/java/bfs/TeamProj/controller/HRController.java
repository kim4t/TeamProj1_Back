package bfs.TeamProj.controller;

import bfs.TeamProj.Service.HRService;
import bfs.TeamProj.constant.Constant;
import bfs.TeamProj.domain.EmployeeProfile;
import bfs.TeamProj.domain.PersonalInformation;
import bfs.TeamProj.security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/hrModule")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", allowCredentials = "true")
public class HRController {
    @Autowired
    private HRService hrService;

    @GetMapping("/employeeProfile")
    public List<EmployeeProfile> getAllEmployeeProfile(HttpServletRequest request){
//        String username = JwtUtil.getSubject(request, Constant.JWT_TOKEN_COOKIE_NAME, Constant.SIGNING_KEY);
//        System.out.println(username);
//        if(username == null) {
//            return null;
//        }
        return hrService.getAllEmployeeProfile();
    }

//    @GetMapping("/visaStatusManagement")
//    public String foo (HttpServletRequest request){
//        String username = JwtUtil.getSubject(request, Constant.JWT_TOKEN_COOKIE_NAME, Constant.SIGNING_KEY);
//        System.out.println(username);
//        if(username == null) {
//            return null;
//        }
//        return null;
//    }
}
