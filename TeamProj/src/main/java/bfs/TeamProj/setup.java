package bfs.TeamProj;

import bfs.TeamProj.Service.*;

import bfs.TeamProj.constant.Constant;
import bfs.TeamProj.domain.*;

import bfs.TeamProj.exception.AgeInvalidException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static bfs.TeamProj.constant.Constant.ONBOARD_PENDING;

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
    private ContactService contactService;
    @Autowired
    private AddressService addressService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private HRService hrService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ApplicationWorkFlowService applicationWorkFlowService;
    @Autowired
    private PersonalDocumentService personalDocumentService;
    @Autowired
    private RegistrationTokenService registrationTokenService;

    private static final Logger logger = LoggerFactory.getLogger(setup.class);

    @Override
    public void run(String... args) throws Exception {

        //cleanAlltable();
        //dataSetUp();
        //aopLogging();

    }


    public void aopLogging(){
        logger.info("IN: ", this.getClass());
        //List<Person> personList = personService.getAllPerson();

        /*
        User u = new User();
        u.setUserName("bruceshen");
        u.setPassword("123456");
        u.setEmail("test@gmail.com");
        u.setCreateDate(LocalDate.now());
        u.setModificationDate(LocalDate.now());
        userService.addUser(u);
        */

        //Role role = roleService.getRoleByName("employee");

        //List<RegistrationToken> registrationTokenList = registrationTokenService.getAllToken();
        List<Address> addressList = addressService.getAllAddress();
    }



    public void test(){


        User user = userService.getUserByUserName("qqeq");
        Person person = user.getPerson();
        Employee employee = person.getEmployee();
        List<PersonalDocument> personalDocumentList = employee.getPersonalDocumentList();
        for(PersonalDocument doc:personalDocumentList){
            System.out.println(doc.getTitle());
        }

        /*
        Address address = addressService.getAddressById(1);
        System.out.println(address.getAddressLine1());

        User user = userService.getUserByUserName("qqeq");
        Person p = user.getPerson();
        Employee emp = p.getEmployee();
        Contact contact = p.getContact();
        List<PersonalDocument> docList = emp.getPersonalDocumentList();


        List<Contact> emglist = contactService.getContactsByRefPersonId(p.getId());
        for(Contact c : emglist) {
           Person person = personService.getPersonById(c.getPerson().getId());
           System.out.println(person.getFirstName());
            System.out.println(person.getLastName());
        }

        VisaStatus visaStatus = emp.getVisaStatus();
        System.out.println(visaStatus.getVisaType());
        //Person p = personService.getPersonById(user.getPerson().getId());

        //Role role = user.getUserRole().getRole();
        //UserRole userRole = user.getUserRole();



        //UserRole userRole = userService.getUserByUserName("qqeq").getUserRole();
        //Role role = roleService.getRoleById(userRole.getRole().getId());
        //System.out.println(role.getRoleName());
        //System.out.println(role.toString());
        */

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


    public void dataSetUp() throws AgeInvalidException {
        logger.info("start to insert setup data");


        //set up HR role and permission
        Permission permission = new Permission();
        Role role = new Role();
        RolePermission rolePermission = new RolePermission();
        if (roleService.getRoleByName("HR") == null) {
            //for HR
            permission.setCreateDate(LocalDate.now());
            permission.setLastModificationUser("admin");
            permission.setModificationDate(LocalDate.now());
            permission.setPermissionDescription("admin permission");
            permission.setPermissionName("admin");
            permission = permissionService.addPermission(permission);

            role.setCreateDate(LocalDate.now());
            role.setDescription("role for HR");
            role.setLastModificationUser("admin");
            role.setModificationDate(LocalDate.now());
            role.setRoleName("HR");
            role = roleService.addRole(role);

            rolePermission.setActiveFlag(true);
            rolePermission.setCreateDate(LocalDate.now());
            rolePermission.setLastModificationUser("admin");
            rolePermission.setModificationDate(LocalDate.now());
            rolePermission.setRole(role);
            rolePermission.setPermission(permission);
            permissionService.addRolePermission(rolePermission);
        }
        if(roleService.getRoleByName("employee") == null) {
            //For employee
            permission = new Permission();
            permission.setCreateDate(LocalDate.now());
            permission.setLastModificationUser("employee");
            permission.setModificationDate(LocalDate.now());
            permission.setPermissionDescription("employee permission");
            permission.setPermissionName("employee");
            permission = permissionService.addPermission(permission);

            role = new Role();
            role.setCreateDate(LocalDate.now());
            role.setDescription("role for employee");
            role.setLastModificationUser("admin");
            role.setModificationDate(LocalDate.now());
            role.setRoleName("employee");
            role = roleService.addRole(role);

            rolePermission = new RolePermission();
            rolePermission.setActiveFlag(true);
            rolePermission.setCreateDate(LocalDate.now());
            rolePermission.setLastModificationUser("admin");
            rolePermission.setModificationDate(LocalDate.now());
            rolePermission.setRole(role);
            rolePermission.setPermission(permission);
            permissionService.addRolePermission(rolePermission);
        }

        User u = new User();
        u.setUserName("admin");
        u.setPassword("admin");
        u.setEmail("admin@gmail.com");
        u.setCreateDate(LocalDate.now());
        u.setModificationDate(LocalDate.now());
        userService.addUser(u);
        u = userService.getUserByEmail(u.getEmail());


        //Set the role of this user (Done)
        role = roleService.getRoleByName("HR");
        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUser(u);
        userRole.setActiveFlag(true);
        userRole.setLastModificationUser("admin");
        userRole.setModificationDate(LocalDate.now());
        roleService.addUserRole(userRole);

        Person p = new Person();
        p.setFirstName("admin");
        p.setLastName("admin");
        p.setEmail(u.getEmail());
        p.setCellphone("1234567890");
        p.setGender("I don't want to answer");
        p.setSSN("012345678");
        p.setDOB("1970-01-01");
        p = personService.addPerson(p);

        u.setPerson(p);
        u = userService.updateUser(u);

        Address employeeAddress = new Address();
        employeeAddress.setPerson(p);
        employeeAddress.setAddressLine1("admin address");
        employeeAddress.setAddressLine2("admin address line2");
        employeeAddress.setCity("admin city");
        employeeAddress.setStateAbbr("AL");
        employeeAddress.setStateName("Alabama");
        employeeAddress.setZipCode("35242");
        addressService.addAddress(employeeAddress);

        VisaStatus visaStatus = new VisaStatus();
        visaStatus.setActive(true);
        visaStatus.setCreateUser(u.getUserName());
        visaStatus.setModificationDate(LocalDate.now());
        visaStatus.setVisaType("Green Card");
        visaStatus = visaStatusService.addVisaStatus(visaStatus);

        //add employee information (may have mistake)
        Employee emp = new Employee();
        emp.setPerson(p);
        emp.setVisaStatus(visaStatus);
        emp.setAvatar(Constant.DEFAULT_AVATAR);
        emp.setCar("Audi_Q7_Black");
        emp.setDriverLicense("12345678");
        emp.setDriverLicenseExpirationDate(LocalDate.now().plusYears(5));
        emp.setStartDate(LocalDate.now());
        emp.setEndDate(LocalDate.now().plusYears(1));
        emp.setManagerId(0);
        emp.setTitle("HR");
        emp = employeeService.addEmployee(emp);

        //add user's application work flow information
        ApplicationWorkFlow aWF = new ApplicationWorkFlow();
        aWF.setEmployee(emp);
        aWF.setComments("empty");
        aWF.setCreatedDate(LocalDate.now());
        aWF.setModificationDate(LocalDate.now());
        aWF.setStatus(ONBOARD_PENDING);
        aWF.setType("Green Card");
        applicationWorkFlowService.addApplicationWorkFlow(aWF);

        PersonalDocument dLDoc = new PersonalDocument();
        dLDoc.setComment("default");
        dLDoc.setCreatedBy(u.getUserName());
        dLDoc.setCreatedDate(LocalDate.now());
        dLDoc.setPath("https://proj-angular-bucket.s3.us-east-2.amazonaws.com/HR+Driver+License+file.docx");
        dLDoc.setTitle("Driver License file");
        dLDoc.setEmployee(emp);
        personalDocumentService.addPersonalDocument(dLDoc);

        PersonalDocument workAuthDoc = new PersonalDocument();
        workAuthDoc.setComment("default");
        workAuthDoc.setCreatedBy(u.getUserName());
        workAuthDoc.setCreatedDate(LocalDate.now());
        workAuthDoc.setPath("https://proj-angular-bucket.s3.us-east-2.amazonaws.com/HR+work+authorization+file.docx");
        workAuthDoc.setTitle("work authorization file");
        workAuthDoc.setEmployee(emp);
        personalDocumentService.addPersonalDocument(workAuthDoc);


        Person person = new Person();
        person.setFirstName("Sandy");
        person.setLastName("Mcdaniel");
        person.setCellphone("2221113333");
        person.setEmail("ref@gmail.com");
        person.setGender("NA");
        person.setDOB("NA");
        person.setSSN("NA");
        person = personService.addPerson(person);

        Contact contact = new Contact();
        contact.setPerson(person);
        contact.setIsEmergency(true);
        contact.setIsLandLord(false);
        contact.setIsReference(false);
        contact.setRelationship("friend");
        contact.setTitle("emergency");
        contact.setPerson2(p);
        contactService.addContact(contact);



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
        p = personService.addPerson(p);
        User u = new User();
        u.setUserName("username1");
        u.setPassword("password1");
        u.setEmail("email1");
        u.setCreateDate(LocalDate.now());
        u.setModificationDate(LocalDate.now());
        u.setPerson(p);
        u = userService.addUser(u);
        System.out.println(u.toString());*/
        //User u = userService.getUserById(7);
        //u.setPerson(personService.getPersonById(u.getPerson().getId()));
        //System.out.println(u.toString());
        //System.out.println(u.getPerson().getId());
        //System.out.println(u.getPerson().getFirstName());
        //System.out.println(u.getPerson().getLastName());
        //System.out.println(u);




       /*Optional<RegistrationToken> token = tokenService.getAllToken().stream().filter(c->c.getToken().equals("test token")).findAny();

       if(token.isPresent()){
           System.out.println(token.get().getToken());
       }
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
