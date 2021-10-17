package bfs.TeamProj.Service;

import bfs.TeamProj.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

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

    public List<EmployeeProfile> getAllEmployeeProfile(){
        List<EmployeeProfile> res = new ArrayList<>();
        List<Employee> employeeList = employeeService.getAllEmployee();
        for(Employee e : employeeList){
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

    public List<StatusProfile> getAllStatusProfile(){
        List<StatusProfile> res = new ArrayList<>();
        List<Employee> employeeList = employeeService.getAllEmployee();

        for(Employee e : employeeList){
            StatusProfile statusProfile = new StatusProfile();
            Person p = personService.getPersonById(e.getPerson().getId());
            statusProfile.setEmployeeId(e.getId());
            statusProfile.setFirstName(p.getFirstName());
            statusProfile.setLastName(p.getLastName());
            statusProfile.setMiddleName(p.getMiddleName());
            statusProfile.setVisaEndDate(e.getVisaEndDate());
            statusProfile.setDayLeft(
                    (int)(e.getVisaEndDate().toEpochDay() - LocalDate.now().toEpochDay())
            );
            statusProfile.setStatus(
                    applicationWorkFlowService.getApplicationWorkFlowByEmployeeId(e.getId()).getStatus()
            );
            res.add(statusProfile);
        }
        return res;
    }

    public List<ApplicationForm> getAllApplication(){
        List<ApplicationForm> res = new ArrayList<>();
        List<ApplicationWorkFlow> applicationWorkFlowList = applicationWorkFlowService.getAllApplicationWorkFlow();
        for(ApplicationWorkFlow a : applicationWorkFlowList){
            ApplicationForm newForm = new ApplicationForm();
            newForm.setEmployeeId(a.getEmployee().getId());
            newForm.setLastModifiedDate(a.getModificationDate());
            newForm.setType(a.getType());
            newForm.setStatus(a.getStatus());
            res.add(newForm);
        }
        return res;
    }
}
