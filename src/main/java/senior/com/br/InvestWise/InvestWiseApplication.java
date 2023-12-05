package senior.com.br.InvestWise;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import senior.com.br.InvestWise.domain.user.Roles;
import senior.com.br.InvestWise.domain.user.User;
import senior.com.br.InvestWise.domain.user.UserRepository;

@SpringBootApplication
public class InvestWiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvestWiseApplication.class, args);
	}

	/*
		@Bean
		CommandLineRunner commandLineRunner(UserRepository users, PasswordEncoder encoder) {
		return args -> {
			users.save(new User("William", "william.nogueira@senior.com.br", "admin", encoder.encode("admin"), Roles.ADMIN));
		};
	}
*/
}
