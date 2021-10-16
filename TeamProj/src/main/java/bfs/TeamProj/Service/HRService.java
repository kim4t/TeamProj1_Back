package bfs.TeamProj.Service;

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
        List<Person> personList = personService.getAllPerson();
        for(Person p : personList){
            EmployeeProfile employeeProfile = new EmployeeProfile();
            employeeProfile.setFirstName(p.getFirstName());
            employeeProfile.setMiddleName(p.getMiddleName());
            employeeProfile.setLastName(p.getLastName());
            employeeProfile.setVisaStartDate(
                    employeeService.getEmployeeById(p.getId()).getVisaStartDate()
            );
            employeeProfile.setVisaStatus(employeeService.getEmployeeById(p.getId()).getVisaStatus().getVisaType());
            res.add(employeeProfile);
        }
        return res;
    }
}
