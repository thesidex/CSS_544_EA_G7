package edu.miu.cs.cs544;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"edu.miu.common", "edu.miu.cs.cs544"})
public class Application  {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
