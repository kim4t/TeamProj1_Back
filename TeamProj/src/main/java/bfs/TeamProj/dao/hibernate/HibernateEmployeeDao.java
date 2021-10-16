package bfs.TeamProj.dao.hibernate;

import bfs.TeamProj.dao.AbstractHibernateDAO;
import bfs.TeamProj.dao.EmployeeDao;
import bfs.TeamProj.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateEmployeeDao extends AbstractHibernateDAO<Employee> implements EmployeeDao {
    public HibernateEmployeeDao() {
        setClazz(Employee.class);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return findById(id);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return findAll();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return create(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return update(employee);
    }
}
