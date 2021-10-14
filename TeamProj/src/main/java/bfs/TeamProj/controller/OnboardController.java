package bfs.TeamProj.controller;

import bfs.TeamProj.Service.PersonService;
import bfs.TeamProj.Service.RoleService;
import bfs.TeamProj.Service.UserService;
import bfs.TeamProj.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee/onboard")
@CrossOrigin(origins = "http://localhost:4200")
public class OnboardController {
    @Autowired
    private PersonService personService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;




    @PostMapping
    public Person getEmail(HttpServletRequest request) {

        String email = request.getParameter("email");
        User u = userService.getUserByEmail(email);

        Role role = roleService.getRoleByName("employee");
        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUser(u);
        userRole.setActiveFlag(true);
        userRole.setLastModificationUser("admin");
        userRole.setModificationDate(LocalDate.now());
        roleService.addUserRole(userRole);


        Person p = new Person();
        p.setFirstName(request.getParameter("firstName"));
        p.setLastName(request.getParameter("lastName"));
        p.setMiddleName(request.getParameter("middleName"));
        p.setEmail(request.getParameter("email"));
        p.setGender(request.getParameter("gender"));
        p.setCellphone(request.getParameter("cellphone"));
        p.setAlternatePhone(request.getParameter("alternatePhone"));
        p.setDOB(request.getParameter("DOB"));
        p.setSSN(request.getParameter("SSN"));
        p = personService.addPerson(p);

        //insert personId to user
        u.setPerson(p);
        u = userService.updateUser(u);

        Contact employeeContact = new Contact();
        employeeContact.setPerson(p);


        Address employeeAddress = new Address();
        employeeAddress.setPerson(p);


        VisaStatus visaStatus = new VisaStatus();
        Employee emp = new Employee();

        ApplicationWorkFlow aWF = new ApplicationWorkFlow();
        List<PersonalDocument> documents = new ArrayList<>();


        Person referencePerson = new Person();
        Contact referenceContact = new Contact();
        Address referenceAddress = new Address();

        List<Person> emergencyPerson = new ArrayList<>();
        List<Contact> emergencyContact = new ArrayList<>();


        return p;
    }
}
