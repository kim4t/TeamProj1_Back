package bfs.TeamProj;


import bfs.TeamProj.Service.EmailSenderService;
import bfs.TeamProj.Service.RegistrationTokenService;
import bfs.TeamProj.config.JdbcConfig;
import bfs.TeamProj.domain.RegistrationToken;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.EventListener;
import java.util.UUID;

@SpringBootApplication
public class TeamProjApplication {
	@Autowired
	private EmailSenderService emailSenderService;

	public static void main(String[] args) {
//		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
//		RegistrationTokenService registrationTokenService = context.getBean("testService", RegistrationTokenService.class);
		SpringApplication.run(TeamProjApplication.class, args);

	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail(){
		emailSenderService.sendSimpleEmail("taetaehoKim@gmail.com");

	}

}
