package bfs.TeamProj.controller;

import bfs.TeamProj.Service.EmployeeVisaService;
import bfs.TeamProj.constant.Constant;
import bfs.TeamProj.domain.EmployeeVisaInformation;
import bfs.TeamProj.domain.PersonalInformation;
import bfs.TeamProj.security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/employee/visa")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", allowCredentials = "true")
public class EmployeeVisaController {
    @Autowired
    private EmployeeVisaService employeeVisaService;

    @GetMapping("/homePage")
    public EmployeeVisaInformation userInfo(HttpServletRequest request) {
        String username = JwtUtil.getSubject(request, Constant.JWT_TOKEN_COOKIE_NAME, Constant.SIGNING_KEY);
        if (username == null) {
            return null;
        }
        return employeeVisaService.assemble(username);
    }

    @PostMapping("/upload")
    public EmployeeVisaInformation.VisaDocument uploadVisa (HttpServletRequest request, @RequestBody EmployeeVisaInformation.VisaDocument visaDocument) {
        String username = JwtUtil.getSubject(request, Constant.JWT_TOKEN_COOKIE_NAME, Constant.SIGNING_KEY);
        System.out.println(username);
        if (username == null) {
            return null;
        }
        employeeVisaService.uploadVisa(visaDocument, username);
        return visaDocument;
    }
}
