package bfs.TeamProj.Service;

import bfs.TeamProj.constant.Constant;
import bfs.TeamProj.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OnBoardService {
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
    private PersonalDocumentService personalDocumentService;
    @Autowired
    private ContactService contactService;

    public String assemble(OnBoardDataHolder holder) {
        String email = holder.getEmail();
        User u = userService.getUserByEmail(email);
        if (u == null) {
            return "error email";
        }

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
        p.setFirstName(holder.getFirstName());
        p.setLastName(holder.getLastName());
        p.setMiddleName(holder.getMiddleName());
        p.setEmail(email);
        p.setGender(holder.getGender());
        p.setCellphone(holder.getCellphone());
        p.setAlternatePhone(holder.getAlternatePhone());
        p.setDOB(holder.getDob());
        p.setSSN(holder.getSsn());
        p = personService.addPerson(p);

        //update user with personId (Done)
        u.setPerson(p);
        u = userService.updateUser(u);

        //add user's address information (Done)
        Address employeeAddress = new Address();
        employeeAddress.setPerson(p);
        employeeAddress.setAddressLine1(holder.getAddressLine1());
        employeeAddress.setAddressLine2(holder.getAddressLine2());
        employeeAddress.setCity(holder.getCity());
        employeeAddress.setStateAbbr(holder.getStateAbbr());
        employeeAddress.setStateName(holder.getStateName());
        employeeAddress.setZipCode(holder.getZipCode());
        addressService.addAddress(employeeAddress);

        //add user's visaStatus information (Done)
        VisaStatus visaStatus = new VisaStatus();
        visaStatus.setActive(true);
        visaStatus.setCreateUser(u.getUserName());
        visaStatus.setModificationDate(LocalDate.now());
        String visaType = holder.getVisaType();
        visaStatus.setVisaType(visaType);
        visaStatus = visaStatusService.addVisaStatus(visaStatus);

        //add employee information (may have mistake)
        Employee emp = new Employee();
        emp.setPerson(p);
        emp.setVisaStatus(visaStatus);
        String avatar = Constant.DEFAULT_AVATAR;
        if (holder.getAvatar() != null) {
            avatar = holder.getAvatar();
        }
        emp.setAvatar(avatar);
        emp.setCar(holder.getCar());
        String driverLicense = holder.getDriverLicense();
        emp.setDriverLicense(driverLicense);
        if (!driverLicense.equals("false")) {
            emp.setDriverLicenseExpirationDate(holder.getDriverLicenseExpirationDate());
        }
        emp.setStartDate(LocalDate.now());
        emp.setEndDate(LocalDate.now().plusYears(1));
        emp.setManagerId(0);
        emp.setTitle("default");
        if (!(visaType.equals("Green Card") || visaType.equals("Citizen"))) {
            emp.setVisaStartDate(holder.getVisaStartDate());
            emp.setVisaEndDate(holder.getVisaEndDate());
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
            dLDoc.setPath(holder.getDriverLicenseDocumentPath());
            dLDoc.setTitle("Driver License file");
            dLDoc.setEmployee(emp);
            personalDocumentService.addPersonalDocument(dLDoc);
        }
        //personal document for work authorization
        PersonalDocument workAuthDoc = new PersonalDocument();
        workAuthDoc.setComment("default");
        workAuthDoc.setCreatedBy(u.getUserName());
        workAuthDoc.setCreatedDate(LocalDate.now());
        workAuthDoc.setPath(holder.getVisaDocumentPath());
        workAuthDoc.setTitle("work authorization file");
        workAuthDoc.setEmployee(emp);
        personalDocumentService.addPersonalDocument(workAuthDoc);
        
        //add the reference person if exist
        if (holder.getFirstNameRef() != null) {
            Person referencePerson = new Person();
            referencePerson.setFirstName(holder.getFirstNameRef());
            referencePerson.setLastName(holder.getLastNameRef());
            referencePerson.setMiddleName(holder.getMiddleNameRef());
            referencePerson.setCellphone(holder.getCellphoneRef());
            referencePerson.setEmail(holder.getEmailRef());
            referencePerson.setGender("NA");
            referencePerson.setDOB("NA");
            referencePerson.setSSN("NA");
            referencePerson = personService.addPerson(referencePerson);

            Contact contact = new Contact();
            contact.setPerson(referencePerson);
            contact.setIsEmergency(false);
            contact.setIsLandLord(false);
            contact.setIsReference(true);
            contact.setRelationship(holder.getRelationshipRef());
            contact.setTitle("reference");
            contact.setPerson2(p);
            contactService.addContact(contact);

            Address referenceAddress = new Address();
            referenceAddress.setPerson(referencePerson);
            referenceAddress.setAddressLine1(holder.getAddressLine1Ref());
            referenceAddress.setAddressLine2(holder.getAddressLine2Ref());
            referenceAddress.setCity(holder.getCityRef());
            referenceAddress.setStateAbbr(holder.getStateAbbrRef());
            referenceAddress.setStateName(holder.getStateNameRef());
            referenceAddress.setZipCode(holder.getZipCodeRef());
            addressService.addAddress(referenceAddress);
        }

        //add the emergency contact list
        for (OnBoardDataHolder.EmergencyContact emergencyCount : holder.getEmergencyContact()) {
            Person person = new Person();
            person.setFirstName(emergencyCount.getFirstName());
            person.setLastName(emergencyCount.getLastName());
            person.setMiddleName(emergencyCount.getMiddleName());
            person.setCellphone(emergencyCount.getCellphone());
            person.setEmail(emergencyCount.getEmail());
            person.setGender("NA");
            person.setDOB("NA");
            person.setSSN("NA");
            person = personService.addPerson(person);

            Contact contact = new Contact();
            contact.setPerson(person);
            contact.setIsEmergency(true);
            contact.setIsLandLord(false);
            contact.setIsReference(false);
            contact.setRelationship(emergencyCount.getRelationship());
            contact.setTitle("emergency");
            contact.setPerson2(p);
            contactService.addContact(contact);
        }
        return "Done";
    }
}
