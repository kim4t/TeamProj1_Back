package bfs.TeamProj.Service;

import bfs.TeamProj.dao.EmployeeDao;
import bfs.TeamProj.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Transactional
    public Employee getEmployeeById(int id) {
        return employeeDao.getEmployeeById(id);
    }

    @Transactional
    public List<Employee> getAllEmployee() {
        return employeeDao.getAllEmployee();
    }

    @Transactional
    public Employee addEmployee(Employee employee) {
        return employeeDao.addEmployee(employee);
    }

}
