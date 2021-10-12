package bfs.TeamProj;

import bfs.TeamProj.Service.PersonService;
import bfs.TeamProj.Service.RegistrationTokenService;
import bfs.TeamProj.Service.UserService;
import bfs.TeamProj.domain.Person;
import bfs.TeamProj.domain.RegistrationToken;
import bfs.TeamProj.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class setup implements CommandLineRunner {
    @Autowired
    private PersonService personService;
    @Autowired
    private UserService userService;
    @Autowired
    private RegistrationTokenService tokenService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger logger = LoggerFactory.getLogger(setup.class);

    @Override
    public void run(String... args) throws Exception {
        //cleanAlltable();
        //dataSetUp();
    }

    //used to remove all table from database
    public void cleanAlltable() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS digital_document");
        jdbcTemplate.execute("DROP TABLE IF EXISTS registration_token");
        jdbcTemplate.execute("DROP TABLE IF EXISTS role_permission");
        jdbcTemplate.execute("DROP TABLE IF EXISTS user_role");
        jdbcTemplate.execute("DROP TABLE IF EXISTS permission");
        jdbcTemplate.execute("DROP TABLE IF EXISTS role");
        jdbcTemplate.execute("DROP TABLE IF EXISTS user");
        jdbcTemplate.execute("DROP TABLE IF EXISTS application_work_flow");
        jdbcTemplate.execute("DROP TABLE IF EXISTS facility");
        jdbcTemplate.execute("DROP TABLE IF EXISTS address");
        jdbcTemplate.execute("DROP TABLE IF EXISTS facility_report_detail");
        jdbcTemplate.execute("DROP TABLE IF EXISTS facility_report");
        jdbcTemplate.execute("DROP TABLE IF EXISTS personal_document");
        jdbcTemplate.execute("DROP TABLE IF EXISTS employee");
        jdbcTemplate.execute("DROP TABLE IF EXISTS house");
        jdbcTemplate.execute("DROP TABLE IF EXISTS contact");
        jdbcTemplate.execute("DROP TABLE IF EXISTS person");
    }

    public void dataSetUp() {
        logger.info("start to insert data");

        RegistrationToken token = new RegistrationToken();
        token.setToken("test token");
        token.setCreatedBy("admin");
        token.setEmail("abc@1234");
        token.setValidDuration(LocalDateTime.now());
        tokenService.addToken(token);
        /*
        Person p = new Person();
        p.setFirstName("name123131");
        p.setLastName("name22131");
        p.setMiddleName("name3");
        p.setEmail("mail");
        p.setCellphone("1234");
        p.setAlternatePhone("2345");
        p.setGender("M");
        p.setSSN("456");
        p.setDOB("890");
        int id = personService.addPerson(p);
        System.out.println("inserted id:" + id);

        User u = new User();
        u.setUserName("username1");
        u.setPassword("password1");
        u.setEmail("email1");
        u.setCreateDate(LocalDate.now());
        u.setModificationDate(LocalDate.now());
        int userId = userService.addUser(u, id);
        System.out.println("User id:" + userId);

        //Person p2 = personService.getPersonById(4);
        //logger.info(p2.toString());
        //User u2 = userService.getUserById(1);
        //logger.info(u2.toString());
        */
    }
}
