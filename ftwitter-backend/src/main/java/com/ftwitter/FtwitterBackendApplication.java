package com.ftwitter;

import com.ftwitter.models.ApplicationUser;
import com.ftwitter.repositories.RoleRepository;
import com.ftwitter.repositories.UserRepository;
import com.ftwitter.models.Role;
import com.ftwitter.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;

@SpringBootApplication
public class FtwitterBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FtwitterBackendApplication.class,
				args);
	}

	@Bean
	CommandLineRunner run(RoleRepository roleRepo, UserService userService) {
		return args -> {
			roleRepo.save(new Role(1, "USER"));
			/*ApplicationUser u = new ApplicationUser();
			u.setFirstName("david");
			u.setLastName("zaton");

			userService.registerUser(u);

			 */
		};
	}
}
