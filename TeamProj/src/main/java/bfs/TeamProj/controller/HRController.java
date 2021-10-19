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
//        if (username == null) {
//            return null;
//        }
        return hrService.getAllStatusProfile();
    }

    @GetMapping("/applicationReview")
    public List<ApplicationForm> getAllApplication(HttpServletRequest request) {
//        String username = JwtUtil.getSubject(request, Constant.JWT_TOKEN_COOKIE_NAME, Constant.SIGNING_KEY);
//        System.out.println(username);
//        if (username == null) {
//            return null;
//        }
        return hrService.getAllApplication();
    }

    @PostMapping("/applicationReviewDetail")
    public OnBoardDataHolder getApplicationDetailById(HttpServletResponse httpServletResponse, Integer employeeId, HttpServletRequest request) {
//        String username = JwtUtil.getSubject(request, Constant.JWT_TOKEN_COOKIE_NAME, Constant.SIGNING_KEY);
//        System.out.println(username);
//        if (username == null) {
//            return null;
//        }
        System.out.println(employeeId);

        return hrService.getApplicationDetailById(employeeId);
    }

    @PostMapping("/applicationReviewDetail/update")
    public ApplicationWorkFlow changeStatus(HttpServletResponse httpServletResponse,
                                            int employeeId, String status, String comments, HttpServletRequest request) {

//        String username = JwtUtil.getSubject(request, Constant.JWT_TOKEN_COOKIE_NAME, Constant.SIGNING_KEY);
//        System.out.println(username);
//        if (username == null) {
//            return null;
//        }
        System.out.println();
        System.out.println(comments);
        return hrService.updateApplicationWorkFlow(employeeId, status, comments);
    }

    @PostMapping("/documentationReviewDetail")
    public List<DocumentationReviewForm> getApplicationDtailById(HttpServletResponse httpServletResponse, Integer employeeId, String title, HttpServletRequest request) {
//        String username = JwtUtil.getSubject(request, Constant.JWT_TOKEN_COOKIE_NAME, Constant.SIGNING_KEY);
//        System.out.println(username);
//        if (username == null) {
//            return null;
//        }
        System.out.println(employeeId);

        return hrService.getPersonalDocumentListByEmployeeId(employeeId,title);
    }

    @PostMapping("/documentationReviewDetail/update")
    public ApplicationWorkFlow changeOptStatus(HttpServletResponse httpServletResponse,
                                            int employeeId, String status, String comments, String type, HttpServletRequest request) {

//        String username = JwtUtil.getSubject(request, Constant.JWT_TOKEN_COOKIE_NAME, Constant.SIGNING_KEY);
//        System.out.println(username);
//        if (username == null) {
//            return null;
//        }
        System.out.println();
        System.out.println(comments);
        return hrService.updateOptApplicationWorkFlow(employeeId, status, comments, type);
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
