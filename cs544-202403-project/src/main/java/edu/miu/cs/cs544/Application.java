package edu.miu.cs.cs544;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication(scanBasePackages = {"edu.miu.common", "edu.miu.cs.cs544"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public ApplicationRunner applicationRunner(Environment environment) {
		return args -> {
			// Retrieve and log the database URL
			String databaseUrl = environment.getProperty("spring.datasource.url");
			System.out.println("Database URL: " + databaseUrl);

			// If you want to log additional properties, you can do so here
			// For example, logging the active profiles
			String[] activeProfiles = environment.getActiveProfiles();
			System.out.println("Active Profiles: " + String.join(", ", activeProfiles));
		};
	}
}
