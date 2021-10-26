package bfs.TeamProj;

import bfs.TeamProj.Service.EmailSenderService;
import bfs.TeamProj.config.JdbcConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.UUID;
@SpringBootApplication
@EnableAsync
public class TeamProjApplication {
	@Autowired
	private EmailSenderService emailSenderService;

	public static void main(String[] args) {
//		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
//		TestService testService = context.getBean("testService", TestService.class);
//		testService.foo("test",123);

		SpringApplication.run(TeamProjApplication.class, args);


	}




}
