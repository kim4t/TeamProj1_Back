package bfs.TeamProj;

import bfs.TeamProj.Service.TestService;
import bfs.TeamProj.config.JdbcConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class TeamProjApplication {

	public static void main(String[] args) {

//		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
//		TestService testService = context.getBean("testService", TestService.class);
//		testService.foo("test",123);

		SpringApplication.run(TeamProjApplication.class, args);

	}

}
