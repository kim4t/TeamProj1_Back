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
    private ContactService contactService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private VisaStatusService visaStatusService;
    @Autowired
    private PersonalDocumentService personalDocumentService;

    public PersonalInformation.NameSection updateName(PersonalInformation.NameSection nameSection) {
        Person person = personService.getPersonById(nameSection.getPersonId());
        Employee employee = employeeService.getEmployeeById(person.getEmployee().getId());
        System.out.println(employee.getAvatar());
        person.setFirstName(nameSection.getFirstName());
        person.setLastName(nameSection.getLastName());
        person.setMiddleName(nameSection.getMiddleName());
        person.setDOB(nameSection.getDob());
        person.setGender(nameSection.getGender());
        person.setSSN(nameSection.getSsn());
        employee.setAvatar(nameSection.getAvatar());
        personService.updatePerson(person);
        employeeService.updateEmployee(employee);
        return nameSection;
    }

    public PersonalInformation.AddressSection updateAddress(PersonalInformation.AddressSection addressSection) {
        Address address = addressService.getAddressById(addressSection.getAddressId());
        address.setAddressLine1(addressSection.getAddressLine1());
        address.setAddressLine2(addressSection.getAddressLine2());
        address.setCity(addressSection.getCity());
        address.setStateAbbr(addressSection.getStateAbbr());
        address.setStateName(addressSection.getStateName());
        address.setZipCode(addressSection.getZipCode());
        addressService.updateAddress(address);
        return addressSection;
    }

    public PersonalInformation.ContactSection updateContact(PersonalInformation.ContactSection contactSection) {
        Person person = personService.getPersonById(contactSection.getPersonId());
        person.setCellphone(contactSection.getCellphone());
        person.setAlternatePhone(contactSection.getAlternatePhone());
        personService.updatePerson(person);
        return contactSection;
    }

    public PersonalInformation.EmployeeSection updateEmployee(PersonalInformation.EmployeeSection employeeSection) {
        Employee employee = employeeService.getEmployeeById(employeeSection.getEmployeeId());
        VisaStatus visaStatus = employee.getVisaStatus();
        visaStatus.setVisaType(employeeSection.getVisaType());
        visaStatus.setModificationDate(LocalDate.now());
        visaStatusService.updateVisaStatus(visaStatus);
        employee.setVisaStartDate(employeeSection.getVisaStartDate());
        employee.setVisaEndDate(employeeSection.getVisaEndDate());
        employee.setStartDate(employeeSection.getStartDate());
        employee.setEndDate(employeeSection.getEndDate());
        employee.setTitle(employee.getTitle());
        employeeService.updateEmployee(employee);
        return employeeSection;
    }

    public List<PersonalInformation.EmergencyContact> updateEmergency(List<PersonalInformation.EmergencyContact> emergencyContactList) {
        for (PersonalInformation.EmergencyContact emgContact : emergencyContactList) {
            Person person = personService.getPersonById(emgContact.getPersonId());
            Contact contact = contactService.getContactById(person.getContact().getId());
            contact.setRelationship(emgContact.getRelationship());
            contactService.updateContact(contact);
            person.setFirstName(emgContact.getFirstName());
            person.setLastName(emgContact.getLastName());
            person.setCellphone(emgContact.getCellphone());
            person.setEmail(emgContact.getEmail());
            personService.updatePerson(person);
        }
        return emergencyContactList;
    }

    public List<PersonalInformation.PersonalDocument> updateDocument(List<PersonalInformation.PersonalDocument> personalDocumentList) {
        for (PersonalInformation.PersonalDocument docSection : personalDocumentList) {
            PersonalDocument doc = personalDocumentService.getPersonalDocumentById(docSection.getDocId());
            if(!doc.getPath().equals(docSection.getPath())){
                doc.setCreatedDate(LocalDate.now());
                docSection.setCreateDate(doc.getCreatedDate());
            }
            doc.setPath(docSection.getPath());
            personalDocumentService.updatePersonalDocument(doc);
        }
        return personalDocumentList;
    }

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
        nameSection.setMiddleName(person.getMiddleName());
        nameSection.setAvatar(employee.getAvatar());
        nameSection.setDob(person.getDOB());
        nameSection.setGender(person.getGender());
        nameSection.setSsn(person.getSSN());
        info.setNameSection(nameSection);

        //address section
        PersonalInformation.AddressSection addressSection = new PersonalInformation.AddressSection();
        addressSection.setAddressId(address.getId());
        addressSection.setAddressLine1(address.getAddressLine1());
        addressSection.setAddressLine2(address.getAddressLine2());
        addressSection.setCity(address.getCity());
        addressSection.setStateAbbr(address.getStateAbbr());
        addressSection.setStateName(address.getStateName());
        addressSection.setZipCode(address.getZipCode());
        info.setAddressSection(addressSection);

        //contact section
        PersonalInformation.ContactSection contactSection = new PersonalInformation.ContactSection();
        contactSection.setPersonId(person.getId());
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
            if (c.getIsEmergency()) {
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
        }
        info.setEmergencyContactList(emergencyContactList);

        //personal document section
        List<PersonalInformation.PersonalDocument> personalDocumentList = new ArrayList<>();
        for (PersonalDocument doc : docList) {
            PersonalInformation.PersonalDocument document = new PersonalInformation.PersonalDocument();
            document.setDocId(doc.getId());
            document.setPath(doc.getPath());
            document.setTitle(doc.getTitle());
            document.setCreateDate(doc.getCreatedDate());
            personalDocumentList.add(document);
        }
        info.setPersonalDocumentList(personalDocumentList);

        return info;
    }

}
