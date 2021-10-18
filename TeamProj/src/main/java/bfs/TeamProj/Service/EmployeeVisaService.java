package bfs.TeamProj.Service;

import bfs.TeamProj.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeVisaService {
    @Autowired
    private PersonService personService;
    @Autowired
    private UserService userService;
    @Autowired
    private DigitalDocumentService digitalDocumentService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private VisaStatusService visaStatusService;
    @Autowired
    private PersonalDocumentService personalDocumentService;

    public EmployeeVisaInformation assemble(String username) {
        EmployeeVisaInformation employeeVisaInformation = new EmployeeVisaInformation();
        User user = userService.getUserByUserName(username);
        Person person = user.getPerson();
        Employee employee = person.getEmployee();
        ApplicationWorkFlow applicationWorkFlow = employee.getApplicationWorkFlow();

        //assemble visa stage
        EmployeeVisaInformation.VisaStage visaStage = new EmployeeVisaInformation.VisaStage();
        visaStage.setAwfId(applicationWorkFlow.getId());
        visaStage.setStatus(applicationWorkFlow.getStatus());
        visaStage.setType(applicationWorkFlow.getType());
        visaStage.setVisaEndDate(employee.getVisaEndDate());
        visaStage.setUploadedI983(false);
        employeeVisaInformation.setVisaStage(visaStage);

        //assemble sample document
        List<EmployeeVisaInformation.SampleDocument> sampleDocumentList = new ArrayList<>();
        List<DigitalDocument> digitalDocumentList = digitalDocumentService.getAllDigitalDocument();
        for (DigitalDocument doc : digitalDocumentList) {
            EmployeeVisaInformation.SampleDocument sampleDocument = new EmployeeVisaInformation.SampleDocument();
            sampleDocument.setType(doc.getType());
            sampleDocument.setPath(doc.getTemplateLocation());
            sampleDocumentList.add(sampleDocument);
        }
        employeeVisaInformation.setSampleDocumentList(sampleDocumentList);

        //assemble visa document
        List<EmployeeVisaInformation.VisaDocument> visaDocumentList = new ArrayList<>();
        List<PersonalDocument> docList = employee.getPersonalDocumentList();
        String temp = user.getUserName() + '_' + "I-983 file";
        for (PersonalDocument doc : docList) {
            EmployeeVisaInformation.VisaDocument document = new EmployeeVisaInformation.VisaDocument();
            document.setDocId(doc.getId());
            document.setPath(doc.getPath());
            document.setTitle(doc.getTitle());
            if (doc.getTitle().equals(temp)){
                visaStage.setUploadedI983(true);
            }
                document.setCreateDate(doc.getCreatedDate());
            visaDocumentList.add(document);
        }
        employeeVisaInformation.setVisaDocumentList(visaDocumentList);
        return employeeVisaInformation;
    }

    public EmployeeVisaInformation.VisaDocument uploadVisa(EmployeeVisaInformation.VisaDocument visaDocument, String username) {
        User user = userService.getUserByUserName(username);
        Person person = user.getPerson();
        Employee employee = person.getEmployee();

        PersonalDocument personalDocument = personalDocumentService.getPersonalDocumentByTitle(visaDocument.getTitle());
        System.out.println(personalDocument == null);
        if (personalDocument == null) {
            personalDocument = new PersonalDocument();
            personalDocument.setEmployee(employee);
            personalDocument.setCreatedBy(username);
        }
        personalDocument.setCreatedDate(LocalDate.now());
        personalDocument.setTitle(visaDocument.getTitle());
        personalDocument.setComment(visaDocument.getTitle());
        personalDocument.setPath(visaDocument.getPath());
        personalDocumentService.updatePersonalDocument(personalDocument);
        return visaDocument;
    }
}
