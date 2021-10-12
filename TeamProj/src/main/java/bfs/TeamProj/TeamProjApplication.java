package bfs.TeamProj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TeamProjApplication {

	public static void main(String[] args) {

//		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
//		TestService testService = context.getBean("testService", TestService.class);
//		testService.foo("test",123);

		SpringApplication.run(TeamProjApplication.class, args);

	}

}
