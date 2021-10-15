package bfs.TeamProj.Service;

import bfs.TeamProj.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class HomePageService {
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

    public PersonalInformation assemble(String username) {
        User user = userService.getUserByUserName(username);
        Person person = user.getPerson();
        Address address = person.getAddress();
        Employee employee = person.getEmployee();
        VisaStatus visaStatus = employee.getVisaStatus();
        List<PersonalDocument> docList = employee.getPersonalDocumentList();

        PersonalInformation info = new PersonalInformation();

        //name section
        PersonalInformation.NameSection nameSection = new PersonalInformation.NameSection();
        nameSection.setPersonId(person.getId());
        nameSection.setFirstName(person.getFirstName());
        nameSection.setLastName(person.getLastName());
        nameSection.setAvatar(employee.getAvatar());
        nameSection.setDob(person.getDOB());
        nameSection.setGender(person.getGender());
        nameSection.setSsn(person.getSSN());
        info.setNameSection(nameSection);

        //address section
        PersonalInformation.AddressSection addressSection = new PersonalInformation.AddressSection();
        addressSection.setAddressId(address.getId());
        addressSection.setAddressLine1(address.getAddressLine1());
        addressSection.setAddressLine2(addressSection.getAddressLine1());
        addressSection.setCity(address.getCity());
        addressSection.setStateAbbr(address.getStateAbbr());
        addressSection.setStateName(address.getStateName());
        addressSection.setZipCode(address.getZipCode());
        info.setAddressSection(addressSection);

        //contact section
        PersonalInformation.ContactSection contactSection = new PersonalInformation.ContactSection();
        contactSection.setEmail(person.getEmail());
        contactSection.setCellphone(person.getCellphone());
        contactSection.setAlternatePhone(person.getAlternatePhone());
        info.setContactSection(contactSection);

        //employee section
        PersonalInformation.EmployeeSection employeeSection = new PersonalInformation.EmployeeSection();
        employeeSection.setEmployeeId(employee.getId());
        employeeSection.setVisaType(visaStatus.getVisaType());
        employeeSection.setVisaStartDate(employee.getVisaStartDate());
        employeeSection.setVisaEndDate(employee.getVisaEndDate());
        employeeSection.setStartDate(employee.getStartDate());
        employeeSection.setEndDate(employee.getEndDate());
        employeeSection.setTitle(employee.getTitle());
        info.setEmployeeSection(employeeSection);

        //emergency Contact section
        List<PersonalInformation.EmergencyContact> emergencyContactList = new ArrayList<>();
        List<Contact> emglist = contactService.getContactsByRefPersonId(person.getId());
        for (Contact c : emglist) {
            PersonalInformation.EmergencyContact contact = new PersonalInformation.EmergencyContact();
            Person p = personService.getPersonById(c.getPerson().getId());
            contact.setPersonId(p.getId());
            contact.setFirstName(p.getFirstName());
            contact.setLastName(p.getLastName());
            contact.setEmail(p.getEmail());
            contact.setCellphone(p.getCellphone());
            contact.setRelationship(c.getRelationship());
            emergencyContactList.add(contact);
        }
        info.setEmergencyContactList(emergencyContactList);

        //personal document section
        List<PersonalInformation.PersonalDocument> personalDocumentList = new ArrayList<>();
        for (PersonalDocument doc : docList) {
            PersonalInformation.PersonalDocument document = new PersonalInformation.PersonalDocument();
            document.setDocId(doc.getId());
            document.setPath(doc.getPath());
            document.setTitle(doc.getTitle());
            personalDocumentList.add(document);
        }
        info.setPersonalDocumentList(personalDocumentList);

        return info;
    }

}
