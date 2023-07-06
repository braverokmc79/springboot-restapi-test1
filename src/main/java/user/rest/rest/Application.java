package user.rest.rest;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import user.rest.rest.entity.User;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	public ApplicationRunner applicationRunner() {

		return new ApplicationRunner() {
			@Override
			public void run(ApplicationArguments args) throws Exception {

				User.sample();
			}
		};
	}
}
