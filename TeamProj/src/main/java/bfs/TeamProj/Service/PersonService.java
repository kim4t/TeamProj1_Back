package bfs.TeamProj.Service;

import bfs.TeamProj.dao.PersonDao;
import bfs.TeamProj.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("personService")
public class PersonService {
    @Autowired
    private PersonDao personDao;

    @Transactional
    public Integer addPerson(String firstName, String LastName, String midName, String email,
                             String cell, String altPhone, String gender, String ssn, String dob){
        Person p = new Person();
        p.setFirstName(firstName);
        p.setLastName(LastName);
        p.setMiddleName(midName);
        p.setEmail(email);
        p.setCellphone(cell);
        p.setAlternatePhone(altPhone);
        p.setGender(gender);
        p.setSSN(ssn);
        p.setDOB(dob);
        return personDao.addPerson(p);
    }
    @Transactional
    public Person getPersonById(int id) {
        return null;
    }
}
