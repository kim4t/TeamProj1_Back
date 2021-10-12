package bfs.TeamProj;

import bfs.TeamProj.Service.PersonService;
import bfs.TeamProj.Service.UserService;
import bfs.TeamProj.domain.Person;
import bfs.TeamProj.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class setup implements CommandLineRunner {
    @Autowired
    private PersonService personService;
    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(setup.class);

    @Override
    public void run(String... args) throws Exception {
        dataSetUp();
    }

    public void dataSetUp() {
        logger.info("start to insert data");



        /*
        Person p = new Person();
        p.setFirstName("name1");
        p.setLastName("name2");
        p.setMiddleName("name3");
        p.setEmail("mail");
        p.setCellphone("1234");
        p.setAlternatePhone("2345");
        p.setGender("M");
        p.setSSN("456");
        p.setDOB("890");
        int id = personService.addPerson(p);

        Person p2 = personService.getPersonById(4);
        logger.info(p2.toString());



        User u = new User();
        u.setUserName("username1");
        u.setPassword("password1");
        u.setEmail("email1");
        u.setCreateDate(LocalDate.now());
        u.setModificationDate(LocalDate.now());
        int userId = userService.addUser(u, 11);
        System.out.println("User id:" + userId);

        User u2 = userService.getUserById(1);
        logger.info(u2.toString());
       

        personservice.addPerson("name1", "name2", "name3",
                "mail", "1234", "2345", "M", "456", "890");
        Person p = personservice.getPersonById(1);
        logger.info(p.toString());
         */

    }
}
