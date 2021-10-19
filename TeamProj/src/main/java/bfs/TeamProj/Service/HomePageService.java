package bfs.TeamProj.Service;

import bfs.TeamProj.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static bfs.TeamProj.constant.Constant.*;

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
    @Autowired
    private ApplicationWorkFlowService applicationWorkFlowService;

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
        ApplicationWorkFlow applicationWorkFlow = employee.getApplicationWorkFlow();
        VisaStatus visaStatus = employee.getVisaStatus();
        visaStatus.setVisaType(employeeSection.getVisaType());
        visaStatus.setModificationDate(LocalDate.now());
        visaStatusService.updateVisaStatus(visaStatus);
        applicationWorkFlow.setType(employeeSection.getVisaType());
        applicationWorkFlow.setStatus(OPT_COMPLETED);
        applicationWorkFlowService.updateApplicationWorkFlow(applicationWorkFlow);
        employee.setVisaStartDate(employeeSection.getVisaStartDate());
        employee.setVisaEndDate(employeeSection.getVisaEndDate());
        employee.setStartDate(employeeSection.getStartDate());
        employee.setEndDate(employeeSection.getEndDate());
        employee.setTitle(employeeSection.getTitle());
        employee.setCar(employeeSection.getCar());
        employee.setDriverLicense(employeeSection.getDriverLicense());
        employee.setDriverLicenseExpirationDate(employeeSection.getDriverLicenseExpirationDate());
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
            if (!doc.getPath().equals(docSection.getPath())) {
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

        //comment
        info.setHrComment(employee.getApplicationWorkFlow().getComments());
        info.setAppStatus(employee.getApplicationWorkFlow().getStatus());

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
        employeeSection.setCar(employee.getCar());
        employeeSection.setDriverLicense(employee.getDriverLicense());
        employeeSection.setDriverLicenseExpirationDate(employee.getDriverLicenseExpirationDate());
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
            } else if (c.getIsReference()) {
                PersonalInformation.ReferencePerson ref = new PersonalInformation.ReferencePerson();
                Person p = personService.getPersonById(c.getPerson().getId());

                ref.setPersonId(p.getId());
                ref.setFirstName(p.getFirstName());
                ref.setLastName(p.getLastName());
                ref.setMiddleName(p.getMiddleName());
                ref.setEmail(p.getEmail());
                ref.setCellphone(p.getCellphone());
                ref.setRelationship(c.getRelationship());
                Address add = p.getAddress();
                //Address add = addressService.getAddressByPersonId(p.getId());
                PersonalInformation.AddressSection refAddressSection = new PersonalInformation.AddressSection();
                refAddressSection.setAddressId(add.getId());
                refAddressSection.setAddressLine1(add.getAddressLine1());
                refAddressSection.setAddressLine2(add.getAddressLine2());
                refAddressSection.setCity(add.getCity());
                refAddressSection.setStateAbbr(add.getStateAbbr());
                refAddressSection.setStateName(add.getStateName());
                refAddressSection.setZipCode(add.getZipCode());
                ref.setAddressSection(refAddressSection);
                info.setReferencePerson(ref);
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

    public PersonalInformation reOnboard(PersonalInformation personalInformation) {
        //name section
        updateName(personalInformation.getNameSection());
        //address section
        updateAddress(personalInformation.getAddressSection());
        //contact section
        updateContact(personalInformation.getContactSection());
        //employee section
        updateEmployee(personalInformation.getEmployeeSection());
        //emergency contact
        updateEmergency(personalInformation.getEmergencyContactList());
        //personal document
        updateDocument(personalInformation.getPersonalDocumentList());
        //update application workflow
        Person person = personService.getPersonById(personalInformation.getNameSection().getPersonId());
        Employee employee = employeeService.getEmployeeById(person.getEmployee().getId());
        ApplicationWorkFlow applicationWorkFlow = applicationWorkFlowService.getApplicationWorkFlowById(employee.getApplicationWorkFlow().getId());
        applicationWorkFlow.setStatus(ONBOARD_PENDING);
        applicationWorkFlowService.updateApplicationWorkFlow(applicationWorkFlow);
        //update reference person
        PersonalInformation.ReferencePerson referencePersonSection = personalInformation.getReferencePerson();

        Person refPerson = personService.getPersonById(referencePersonSection.getPersonId());
        Contact contact = contactService.getContactById(refPerson.getContact().getId());
        contact.setRelationship(referencePersonSection.getRelationship());
        contactService.updateContact(contact);
        refPerson.setFirstName(referencePersonSection.getFirstName());
        refPerson.setLastName(referencePersonSection.getLastName());
        refPerson.setMiddleName(referencePersonSection.getMiddleName());
        refPerson.setCellphone(referencePersonSection.getCellphone());
        refPerson.setEmail(referencePersonSection.getEmail());
        personService.updatePerson(refPerson);
        updateAddress(referencePersonSection.getAddressSection());
        return personalInformation;
    }
}
