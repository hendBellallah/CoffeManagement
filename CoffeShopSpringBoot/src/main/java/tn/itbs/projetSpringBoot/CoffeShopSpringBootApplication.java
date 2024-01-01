package tn.itbs.projetSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class CoffeShopSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeShopSpringBootApplication.class, args);
	}

}
