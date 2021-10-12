package bfs.TeamProj;

import bfs.TeamProj.Service.PersonService;
import bfs.TeamProj.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class setup implements CommandLineRunner {
    @Autowired
    private PersonService personservice;

    private static final Logger logger = LoggerFactory.getLogger(setup.class);
    @Override
    public void run(String... args) throws Exception {
        dataSetUp();
    }
    public void dataSetUp(){
        logger.info("start to insert data");

        personservice.addPerson("name1", "name2", "name3",
                "mail", "1234", "2345", "M", "456", "890");
        Person p = personservice.getPersonById(4);
        logger.info(p.toString());
    }
}
