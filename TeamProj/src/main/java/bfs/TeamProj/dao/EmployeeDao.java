package bfs.TeamProj.dao;

import bfs.TeamProj.domain.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee getEmployeeById(int id);

    List<Employee> getAllEmployee();

    Integer addEmployee(Employee Employee, int personId, int visaStatusId);
}
