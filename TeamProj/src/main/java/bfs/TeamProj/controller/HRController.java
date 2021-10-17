package bfs.TeamProj.controller;

import bfs.TeamProj.Service.HRService;
import bfs.TeamProj.Service.HouseService;
import bfs.TeamProj.constant.Constant;
import bfs.TeamProj.domain.*;
import bfs.TeamProj.security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/hrModule")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", allowCredentials = "true")
public class HRController {
    @Autowired
    private HRService hrService;

    //@Autowired
    //private HouseService houseService;

    @GetMapping("/employeeProfile")
    public List<EmployeeProfile> getAllEmployeeProfile(HttpServletRequest request) {
//        String username = JwtUtil.getSubject(request, Constant.JWT_TOKEN_COOKIE_NAME, Constant.SIGNING_KEY);
//        System.out.println(username);
//        if(username == null) {
//            return null;
//        }
        return hrService.getAllEmployeeProfile();
    }

    @GetMapping("/statusTracking")
    public List<StatusProfile> getAllStatusProfile(HttpServletRequest request) {
//        String username = JwtUtil.getSubject(request, Constant.JWT_TOKEN_COOKIE_NAME, Constant.SIGNING_KEY);
//        System.out.println(username);
//        if(username == null) {
//            return null;
//        }
        return hrService.getAllStatusProfile();
    }

    @GetMapping("/applicationReview")
    public List<ApplicationForm> getAllApplication(HttpServletRequest request) {
//        String username = JwtUtil.getSubject(request, Constant.JWT_TOKEN_COOKIE_NAME, Constant.SIGNING_KEY);
//        System.out.println(username);
//        if(username == null) {
//            return null;
//        }
        return hrService.getAllApplication();
    }

    @GetMapping("/applicationReview/detail")
    public OnBoardDataHolder getApplicationDetailById(HttpServletResponse httpServletResponse, int employeeId, HttpServletRequest request) {
//        String username = JwtUtil.getSubject(request, Constant.JWT_TOKEN_COOKIE_NAME, Constant.SIGNING_KEY);
//        System.out.println(username);
//        if(username == null) {
//            return null;
//        }

        return hrService.getApplicationDetailById(employeeId);

    }



//    @GetMapping("/visaStatusManagement")
//    public String foo(HttpServletRequest request) {
//        String username = JwtUtil.getSubject(request, Constant.JWT_TOKEN_COOKIE_NAME, Constant.SIGNING_KEY);
//        System.out.println(username);
//        if (username == null) {
//            return null;
//        }
//        return null;
//    }


}
