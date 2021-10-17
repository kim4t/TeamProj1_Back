package bfs.TeamProj.controller;

import bfs.TeamProj.Service.HomePageService;
import bfs.TeamProj.constant.Constant;
import bfs.TeamProj.domain.PersonalInformation;
import bfs.TeamProj.security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", allowCredentials = "true")
public class HomepageController {
    @Autowired
    private HomePageService homePageService;

    @GetMapping("/homePage")
    public PersonalInformation userInfo(HttpServletRequest request) {
        String username = JwtUtil.getSubject(request, Constant.JWT_TOKEN_COOKIE_NAME, Constant.SIGNING_KEY);
        System.out.println(username);
        if (username == null) {
            return null;
        }
        return homePageService.assemble(username);
    }

    @PostMapping("/update/name")
    public PersonalInformation.NameSection updateName(HttpServletRequest request, @RequestBody PersonalInformation.NameSection nameSection) {
        String username = JwtUtil.getSubject(request, Constant.JWT_TOKEN_COOKIE_NAME, Constant.SIGNING_KEY);
        System.out.println(username);
        if (username == null) {
            return null;
        }
        homePageService.updateName(nameSection);
        return nameSection;
    }

    @PostMapping("/update/address")
    public PersonalInformation.AddressSection updateAddress(HttpServletRequest request, @RequestBody PersonalInformation.AddressSection addressSection) {
        String username = JwtUtil.getSubject(request, Constant.JWT_TOKEN_COOKIE_NAME, Constant.SIGNING_KEY);
        System.out.println(username);
        if (username == null) {
            return null;
        }
        homePageService.updateAddress(addressSection);
        return addressSection;
    }

    @PostMapping("/update/contact")
    public PersonalInformation.ContactSection updateContact(HttpServletRequest request, @RequestBody PersonalInformation.ContactSection contactSection) {
        String username = JwtUtil.getSubject(request, Constant.JWT_TOKEN_COOKIE_NAME, Constant.SIGNING_KEY);
        System.out.println(username);
        if (username == null) {
            return null;
        }
        homePageService.updateContact(contactSection);
        return contactSection;
    }

    @PostMapping("/update/employee")
    public PersonalInformation.EmployeeSection updateEmployee(HttpServletRequest request, @RequestBody PersonalInformation.EmployeeSection employeeSection) {
        String username = JwtUtil.getSubject(request, Constant.JWT_TOKEN_COOKIE_NAME, Constant.SIGNING_KEY);
        System.out.println(username);
        if (username == null) {
            return null;
        }
        homePageService.updateEmployee(employeeSection);
        return employeeSection;
    }
}
