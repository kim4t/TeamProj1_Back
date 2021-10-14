package bfs.TeamProj.controller;

import bfs.TeamProj.Service.*;
import bfs.TeamProj.dao.ContactDao;
import bfs.TeamProj.dao.PersonalDocumentDao;
import bfs.TeamProj.domain.*;
import bfs.TeamProj.constant.Constant;
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
    @Autowired
    private AddressService addressService;
    @Autowired
    private VisaStatusService visaStatusService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ApplicationWorkFlowService applicationWorkFlowService;
    @Autowired
    private PersonalDocumentDao personalDocumentDao;
    @Autowired
    private ContactDao contactDao;

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

        //add user's address information (Done)
        Address employeeAddress = new Address();
        employeeAddress.setPerson(p);
        employeeAddress.setAddressLine1(request.getParameter("addressLine1"));
        employeeAddress.setAddressLine2(request.getParameter("addressLine2"));
        employeeAddress.setCity(request.getParameter("city"));
        employeeAddress.setStateAbbr(request.getParameter("stateAbbr"));
        employeeAddress.setStateName(request.getParameter("stateName"));
        employeeAddress.setZipCode(request.getParameter("zipCode"));
        addressService.addAddress(employeeAddress);

        //add user's visaStatus information (Done)
        VisaStatus visaStatus = new VisaStatus();
        visaStatus.setActive(true);
        visaStatus.setCreateUser(u.getUserName());
        visaStatus.setModificationDate(LocalDate.now());
        String visaType = request.getParameter("visaType");
        visaStatus.setVisaType(visaType);
        visaStatus = visaStatusService.addVisaStatus(visaStatus);

        //add employee information (may have mistake)
        Employee emp = new Employee();
        emp.setPerson(p);
        emp.setVisaStatus(visaStatus);
        String avatar = request.getParameter("avatar") == null ? Constant.DEFAULT_AVATAR : request.getParameter("avatar");
        emp.setAvatar(avatar);
        emp.setCar(request.getParameter("car"));
        String driverLicense = request.getParameter("driverLicense");
        emp.setDriverLicense(driverLicense);
        if (!driverLicense.equals("false")) {
            emp.setDriverLicenseExpirationDate(LocalDate.parse(request.getParameter("driverLicenseExpirationDate")));
        }
        emp.setStartDate(LocalDate.now());
        emp.setEndDate(LocalDate.now().plusYears(1));
        emp.setManagerId(0);
        emp.setTitle("default");
        if (!(visaType.equals("Green Card") || visaType.equals("Citizen"))) {
            emp.setVisaStartDate(LocalDate.parse(request.getParameter("visaStartDate")));
            emp.setVisaEndDate(LocalDate.parse(request.getParameter("visaStartDate")));
        }
        emp = employeeService.addEmployee(emp);

        //add user's application work flow information
        ApplicationWorkFlow aWF = new ApplicationWorkFlow();
        aWF.setEmployee(emp);
        aWF.setComments("empty");
        aWF.setCreatedDate(LocalDate.now());
        aWF.setModificationDate(LocalDate.now());
        aWF.setStatus("Onboarding");
        aWF.setType("employee");
        applicationWorkFlowService.addApplicationWorkFlow(aWF);

        //personal document for driver license
        if (!driverLicense.equals("false")) {
            PersonalDocument dLDoc = new PersonalDocument();
            dLDoc.setComment("default");
            dLDoc.setCreatedBy(u.getUserName());
            dLDoc.setCreatedDate(LocalDate.now());
            dLDoc.setPath(request.getParameter("driverLicenseDocumentPath"));
            dLDoc.setTitle("Driver License file");
            dLDoc.setEmployee(emp);
            personalDocumentDao.addPersonalDocument(dLDoc);
        }
        //personal document for work authorization
        if (!(visaType.equals("Green Card") || visaType.equals("Citizen"))) {
            PersonalDocument workAuthDoc = new PersonalDocument();
            workAuthDoc.setComment("default");
            workAuthDoc.setCreatedBy(u.getUserName());
            workAuthDoc.setCreatedDate(LocalDate.now());
            workAuthDoc.setPath(request.getParameter("visaDocumentPath"));
            workAuthDoc.setTitle("work authorization file");
            workAuthDoc.setEmployee(emp);
            personalDocumentDao.addPersonalDocument(workAuthDoc);
        }

        //add the reference person if exist
        if(request.getParameter("firstNameRef")!= null) {
            Person referencePerson = new Person();
            referencePerson.setFirstName(request.getParameter("firstNameRef"));
            referencePerson.setLastName(request.getParameter("lastNameRef"));
            referencePerson.setMiddleName(request.getParameter("middleNameRef"));
            referencePerson.setCellphone(request.getParameter("cellphoneRef"));
            referencePerson.setEmail(request.getParameter("emailRef"));
            referencePerson.setGender("NA");
            referencePerson.setDOB("NA");
            referencePerson.setSSN("NA");
            referencePerson = personService.addPerson(referencePerson);

            Contact contact = new Contact();
            contact.setPerson(referencePerson);
            contact.setIsEmergency(false);
            contact.setIsLandLord(false);
            contact.setIsReference(true);
            contact.setRelationship(request.getParameter("relationshipRef"));
            contact.setTitle("reference");
            contact.setPerson2(p);
            contactDao.addContact(contact);

            Address referenceAddress = new Address();
            referenceAddress.setPerson(referencePerson);
            referenceAddress.setAddressLine1(request.getParameter("addressLine1Ref"));
            referenceAddress.setAddressLine2(request.getParameter("addressLine2Ref"));
            referenceAddress.setCity(request.getParameter("cityRef"));
            referenceAddress.setStateAbbr(request.getParameter("stateAbbrRef"));
            referenceAddress.setStateName(request.getParameter("stateNameRef"));
            referenceAddress.setZipCode(request.getParameter("zipCodeRef"));
            addressService.addAddress(referenceAddress);
        }
        
        //add the emergency contact list
        int emergencyCount = Integer.parseInt(request.getParameter("emergencyContactNumber"));
        for(int i = 0; i < emergencyCount; i++) {
            Person person = new Person();
            person.setFirstName(request.getParameter("firstNameEmg" + i));
            person.setLastName(request.getParameter("lastNameEmg" + i));
            person.setMiddleName(request.getParameter("middleNameEmg" + i));
            person.setCellphone(request.getParameter("cellphoneEmg" + i));
            person.setEmail(request.getParameter("emailEmg" + i));
            person.setGender("NA");
            person.setDOB("NA");
            person.setSSN("NA");

            person = personService.addPerson(person);
            Contact contact = new Contact();
            contact.setPerson(person);
            contact.setIsEmergency(true);
            contact.setIsLandLord(false);
            contact.setIsReference(false);
            contact.setRelationship(request.getParameter("relationshipEmg" + i));
            contact.setTitle("emergency");
            contact.setPerson2(p);
            contactDao.addContact(contact);
        }
        return p;
    }
}
