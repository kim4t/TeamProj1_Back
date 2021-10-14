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

        //Set the role of this user (Done)
        Role role = roleService.getRoleByName("employee");
        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUser(u);
        userRole.setActiveFlag(true);
        userRole.setLastModificationUser("admin");
        userRole.setModificationDate(LocalDate.now());
        roleService.addUserRole(userRole);

        //user person information (Done)
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

        //update user with personId (Done)
        u.setPerson(p);
        u = userService.updateUser(u);

        //add user's contact information
        Contact employeeContact = new Contact();
        employeeContact.setPerson(p);
        //contactService.addContact

        //add user's address information
        Address employeeAddress = new Address();
        employeeAddress.setPerson(p);

        //add user's visaStatus information
        VisaStatus visaStatus = new VisaStatus();
        Employee emp = new Employee();

        //add user's application work flow information
        ApplicationWorkFlow aWF = new ApplicationWorkFlow();
        List<PersonalDocument> documents = new ArrayList<>();


        //add the reference person if exist
        Person referencePerson = new Person();
        Contact referenceContact = new Contact();
        Address referenceAddress = new Address();


        //add the emergency contact list
        List<Person> emergencyPersons = new ArrayList<>();
        List<Contact> emergencyContacts = new ArrayList<>();

        //personal documents
        List<PersonalDocument> docs = new ArrayList<>();


        return p;
    }
}
