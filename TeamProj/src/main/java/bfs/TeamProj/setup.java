package bfs.TeamProj;

import bfs.TeamProj.Service.*;

import bfs.TeamProj.domain.*;

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
    private VisaStatusService visaStatusService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    private static final Logger logger = LoggerFactory.getLogger(setup.class);

    @Override
    public void run(String... args) throws Exception {
        dataSetUp();
        //cleanAlltable();
    }


    //used to remove all table from database
    public void cleanAlltable() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS digitalDocument");
        jdbcTemplate.execute("DROP TABLE IF EXISTS registrationToken");
        jdbcTemplate.execute("DROP TABLE IF EXISTS rolePermission");
        jdbcTemplate.execute("DROP TABLE IF EXISTS userRole");
        jdbcTemplate.execute("DROP TABLE IF EXISTS permission");
        jdbcTemplate.execute("DROP TABLE IF EXISTS role");
        jdbcTemplate.execute("DROP TABLE IF EXISTS user");
        jdbcTemplate.execute("DROP TABLE IF EXISTS applicationWorkFlow");
        jdbcTemplate.execute("DROP TABLE IF EXISTS facility");
        jdbcTemplate.execute("DROP TABLE IF EXISTS address");
        jdbcTemplate.execute("DROP TABLE IF EXISTS facilityReportDetail");
        jdbcTemplate.execute("DROP TABLE IF EXISTS facilityReport");
        jdbcTemplate.execute("DROP TABLE IF EXISTS personalDocument");
        jdbcTemplate.execute("DROP TABLE IF EXISTS employee");
        jdbcTemplate.execute("DROP TABLE IF EXISTS visaStatus");
        jdbcTemplate.execute("DROP TABLE IF EXISTS house");
        jdbcTemplate.execute("DROP TABLE IF EXISTS contact");
        jdbcTemplate.execute("DROP TABLE IF EXISTS person");
    }

    public void dataSetUp() {
        //logger.info("start to insert data");
        //User u = userService.getUserByEmail("email1");

        //System.out.println(u.getUserName());
        //System.out.println(tokenService.getAllToken().toString());

/*        VisaStatus v = new VisaStatus();
        v.setActive(true);
        v.setCreateUser("admin");
        v.setModificationDate(LocalDate.now());
        v.setVisaType("OPT");
        int id = visaStatusService.addVisaStatus(v);
        System.out.println("id: " + id);
        System.out.println(visaStatusService.getVisaStatusById(id).toString());
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
        p.setId(id);

        User u = new User();
        u.setUserName("username1");
        u.setPassword("password1");
        u.setEmail("email1");
        u.setCreateDate(LocalDate.now());
        u.setModificationDate(LocalDate.now());
        u.setPerson(p);
        int userId = userService.addUser(u);
        System.out.println("User id:" + userId);

        Permission permission = new Permission();
        RolePermission rolePermission = new RolePermission();
        Role role = new Role();
        permission.setCreateDate(LocalDate.now());
        permission.setLastModificationUser("admin");
        permission.setModificationDate(LocalDate.now());
        permission.setPermissionDescription("admin permission");
        permission.setPermissionName("admin");

        rolePermission.setActiveFlag(true);
        rolePermission.setCreateDate(LocalDate.now());
        rolePermission.setLastModificationUser("admin");
        rolePermission.setModificationDate(LocalDate.now());


        role.setCreateDate(LocalDate.now());
        role.setDescription("role for HR");
        role.setLastModificationUser("admin");
        role.setModificationDate(LocalDate.now());
        role.setRoleName("HR");

        rolePermission.setRole(role);
        rolePermission.setPermission(permissionService.getPermissionById(1));
        role.setRolePermission(rolePermission);
        permission.setRolePermission(rolePermission);

        //permissionService.addPermission(permission);
        roleService.addRole(role);
        //System.out.println("id:" + id);



        VisaStatus v = new VisaStatus();
        v.setActive(true);
        v.setCreateUser("admin");
        v.setModificationDate(LocalDate.now());
        v.setVisaType("OPT");
        int id = visaStatusService.addVisaStatus(v);
        System.out.println("id: " + id);
        System.out.println(visaStatusService.getVisaStatusById(id).toString());

        RegistrationToken token = new RegistrationToken();
        token.setToken("test token");
        token.setCreatedBy("admin");
        token.setEmail("abc@1234");
        token.setValidDuration(LocalDateTime.now());
        tokenService.addToken(token);

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
        id = personService.addPerson(p);
        System.out.println("inserted id:" + id);
        Person p2 = personService.getPersonById(id);
        logger.info(p2.toString());

        User u = new User();
        u.setUserName("username1");
        u.setPassword("password1");
        u.setEmail("email1");
        u.setCreateDate(LocalDate.now());
        u.setModificationDate(LocalDate.now());
        int userId = userService.addUser(u, id);
        System.out.println("User id:" + userId);

        User u2 = userService.getUserById(1);
        logger.info(u2.toString());
        */

    }
}
