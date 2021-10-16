package bfs.TeamProj.Service;

import bfs.TeamProj.domain.Employee;
import bfs.TeamProj.domain.EmployeeProfile;
import bfs.TeamProj.domain.Person;
import bfs.TeamProj.domain.VisaStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HRService {
    @Autowired
    private PersonService personService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private VisaStatusService visaStatusService;

    public List<EmployeeProfile> getAllEmployeeProfile(){
        List<EmployeeProfile> res = new ArrayList<>();
        List<Employee> employeeList = employeeService.getAllEmployee();
        for(Employee e : employeeList){
            EmployeeProfile employeeProfile = new EmployeeProfile();
            Person p = personService.getPersonById(e.getPerson().getId());
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
}
