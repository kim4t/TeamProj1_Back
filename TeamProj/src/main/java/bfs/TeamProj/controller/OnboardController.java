package bfs.TeamProj.controller;

import bfs.TeamProj.Service.PersonService;
import bfs.TeamProj.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/employee/onboard")
@CrossOrigin(origins = "http://localhost:4200")
public class OnboardController {
    @Autowired
    private PersonService personService;

    @PostMapping
    public Person getEmail(HttpServletRequest request) {

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

        return p;
    }
}
