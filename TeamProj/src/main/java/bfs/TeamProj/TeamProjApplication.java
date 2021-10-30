package bfs.TeamProj;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.UUID;
@SpringBootApplication
//@EnableCaching
//@EnableAsync
public class TeamProjApplication {

	public static void main(String[] args) {

		SpringApplication.run(TeamProjApplication.class, args);
	}




}
