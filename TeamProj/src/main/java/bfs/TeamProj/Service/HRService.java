package bfs.TeamProj.Service;

import bfs.TeamProj.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class HRService {
    @Autowired
    private PersonService personService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private VisaStatusService visaStatusService;
    @Autowired
    private ApplicationWorkFlowService applicationWorkFlowService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private PersonalDocumentService personalDocumentService;
    @Autowired
    private ContactService contactService;

    public List<EmployeeProfile> getAllEmployeeProfile() {
        List<EmployeeProfile> res = new ArrayList<>();
        List<Employee> employeeList = employeeService.getAllEmployee();
        for (Employee e : employeeList) {
            EmployeeProfile employeeProfile = new EmployeeProfile();
            Person p = personService.getPersonById(e.getPerson().getId());
            employeeProfile.setEmployeeId(e.getId());
            employeeProfile.setSSN(p.getSSN());
            employeeProfile.setFirstName(p.getFirstName());
            employeeProfile.setMiddleName(p.getMiddleName());
            employeeProfile.setLastName(p.getLastName());
            employeeProfile.setVisaStartDate(
                    e.getVisaStartDate()
            );
            employeeProfile.setVisaStatus(e.getVisaStatus().getVisaType());
            res.add(employeeProfile);
        }
        return res;
    }

    public List<StatusProfile> getAllStatusProfile() {
        List<StatusProfile> res = new ArrayList<>();
        List<Employee> employeeList = employeeService.getAllEmployee();

        for (Employee e : employeeList) {
            StatusProfile statusProfile = new StatusProfile();
            Person p = personService.getPersonById(e.getPerson().getId());
            statusProfile.setEmployeeId(e.getId());
            statusProfile.setFirstName(p.getFirstName());
            statusProfile.setLastName(p.getLastName());
            statusProfile.setMiddleName(p.getMiddleName());
            statusProfile.setVisaEndDate(e.getVisaEndDate());
            if(e.getVisaStatus().getVisaType().equals("Green Card") || e.getVisaStatus().getVisaType().equals("Citizen")){
                System.out.println("hi");
                statusProfile.setDayLeft(9999999);
            }
            else{
                statusProfile.setDayLeft(
                        (int) (e.getVisaEndDate().toEpochDay() - LocalDate.now().toEpochDay())
                );
            }

            statusProfile.setStatus(
                    applicationWorkFlowService.getApplicationWorkFlowByEmployeeId(e.getId()).getStatus()
            );
            res.add(statusProfile);
        }
        return res;
    }

    public List<ApplicationForm> getAllApplication() {
        List<ApplicationForm> res = new ArrayList<>();
        List<ApplicationWorkFlow> applicationWorkFlowList = applicationWorkFlowService.getAllApplicationWorkFlow();
        for (ApplicationWorkFlow a : applicationWorkFlowList) {
            ApplicationForm newForm = new ApplicationForm();
            newForm.setEmployeeId(a.getEmployee().getId());
            newForm.setLastModifiedDate(a.getModificationDate());
            newForm.setType(a.getType());
            newForm.setStatus(a.getStatus());
            res.add(newForm);
        }
        return res;
    }

    public OnBoardDataHolder getApplicationDetailById(int employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        Person person = personService.getPersonById(employee.getPerson().getId());
        Address address = addressService.getAddressById(person.getAddress().getId());
        List<PersonalDocument> personalDocumentList = personalDocumentService.getPersonalDocumentListByEmployeeId(employeeId);
        OnBoardDataHolder data = new OnBoardDataHolder();

        //from Person
        data.setFirstName(person.getFirstName());
        data.setLastName(person.getLastName());
        data.setMiddleName(person.getMiddleName());
        data.setEmail(person.getEmail());
        data.setCellphone(person.getCellphone());
        data.setAlternatePhone(person.getAlternatePhone());
        data.setGender(person.getGender());
        data.setSsn(person.getSSN());
        data.setDob(person.getDOB());

        //from Address
        data.setAddressLine1(address.getAddressLine1());
        data.setAddressLine2(address.getAddressLine2());
        data.setCity(address.getCity());
        data.setStateAbbr(address.getStateAbbr());
        data.setStateName(address.getStateName());
        data.setZipCode(address.getZipCode());

        //from Employee
        data.setVisaStartDate(employee.getVisaStartDate());
        data.setVisaEndDate(employee.getVisaEndDate());
        data.setVisaType(employee.getVisaStatus().getVisaType());
        data.setDriverLicense(employee.getDriverLicense());
        data.setDriverLicenseExpirationDate(employee.getDriverLicenseExpirationDate());
        data.setCar(employee.getCar());
        data.setAvatar(employee.getAvatar());

        //from PersonalDocument
        String visaDocumentPath = null;
        String driverLicensePath = null;
        for (PersonalDocument pd : personalDocumentList) {
            if (visaDocumentPath != null && driverLicensePath != null)
                break;
            else if (pd.getTitle().equals("work authorization file"))
                visaDocumentPath = pd.getTitle();
            else if (pd.getTitle().equals("Driver License file"))
                driverLicensePath = pd.getTitle();
        }
        data.setVisaDocumentPath(visaDocumentPath);
        data.setDriverLicenseDocumentPath(driverLicensePath);

        //from contact
        List<Contact> contactList = contactService.getContactsByRefPersonId(person.getId());
        Contact refferenceContact = null;
        for(Contact c : contactList){
            if(c.getIsReference()){
                refferenceContact = c;
                break;
            }
        }
        if(refferenceContact!=null){
            Person refPerson = personService.getPersonById(refferenceContact.getPerson().getId());
            data.setFirstNameRef(refPerson.getFirstName());
            data.setLastNameRef(refPerson.getLastName());
            data.setMiddleNameRef(refPerson.getMiddleName());
            data.setEmailRef(refPerson.getEmail());
            data.setCellphoneRef(refPerson.getCellphone());
            data.setAddressLine1Ref(refPerson.getAddress().getAddressLine1());
            data.setAddressLine2Ref(refPerson.getAddress().getAddressLine2());
            data.setCityRef(refPerson.getAddress().getCity());
            data.setStateNameRef(refPerson.getAddress().getStateName());
            data.setStateNameRef(refPerson.getAddress().getStateAbbr());
            data.setZipCodeRef(refPerson.getAddress().getZipCode());
            data.setRelationshipRef(refferenceContact.getRelationship());

        }
        List<OnBoardDataHolder.EmergencyContact> emergencyContactList =
                 new ArrayList<>();
        for(Contact c : contactList){
            if(c.getIsEmergency()){
                OnBoardDataHolder.EmergencyContact newEmergencyContact = new OnBoardDataHolder.EmergencyContact();
                Person p =personService.getPersonById(c.getPerson().getId());
                newEmergencyContact.setFirstName(p.getFirstName());
                newEmergencyContact.setLastName(p.getLastName());
                newEmergencyContact.setMiddleName(p.getMiddleName());
                newEmergencyContact.setEmail(p.getEmail());
                newEmergencyContact.setCellphone(p.getCellphone());
                newEmergencyContact.setRelationship(c.getRelationship());
                emergencyContactList.add(newEmergencyContact);
            }

        }
        data.setEmergencyContact(emergencyContactList);

        return data;
    }

    public ApplicationWorkFlow updateApplicationWorkFlow(int employeeId, String status, String comments){
        ApplicationWorkFlow current = applicationWorkFlowService.getApplicationWorkFlowByEmployeeId(employeeId);
        ApplicationWorkFlow applicationWorkFlow = new ApplicationWorkFlow();
        applicationWorkFlow.setStatus(status);
        applicationWorkFlow.setModificationDate(LocalDate.now());
        applicationWorkFlow.setComments(comments);
        applicationWorkFlow.setId(current.getId());
        applicationWorkFlow.setType(current.getType());
        applicationWorkFlow.setCreatedDate(current.getCreatedDate());
        applicationWorkFlow.setEmployee(current.getEmployee());
       return applicationWorkFlowService.updateApplicationWorkFlow(applicationWorkFlow);
    }

    public ApplicationWorkFlow updateOptApplicationWorkFlow(int employeeId, String status, String comments, String type){
        ApplicationWorkFlow current = applicationWorkFlowService.getApplicationWorkFlowByEmployeeId(employeeId);
        ApplicationWorkFlow applicationWorkFlow = new ApplicationWorkFlow();
        applicationWorkFlow.setStatus(status);
        applicationWorkFlow.setModificationDate(LocalDate.now());
        applicationWorkFlow.setComments(comments);
        applicationWorkFlow.setId(current.getId());
        applicationWorkFlow.setType(type);
        applicationWorkFlow.setCreatedDate(current.getCreatedDate());
        applicationWorkFlow.setEmployee(current.getEmployee());
        return applicationWorkFlowService.updateApplicationWorkFlow(applicationWorkFlow);
    }


    public List<DocumentationReviewForm> getPersonalDocumentListByEmployeeId(int employeeId,String title){
        List<DocumentationReviewForm> res = new ArrayList<>();
        List<PersonalDocument> documentList = personalDocumentService.getPersonalDocumentListByEmployeeId(employeeId);
        System.out.println("title is: "+title);
        for(PersonalDocument pd : documentList){
            if(pd.getTitle().equals(title)) {
                DocumentationReviewForm dc = new DocumentationReviewForm();
                dc.setId(pd.getId());
                dc.setPath(pd.getPath());
                dc.setTitle(pd.getTitle());
                res.add(dc);
            }
        }

        return res;
    }
}
