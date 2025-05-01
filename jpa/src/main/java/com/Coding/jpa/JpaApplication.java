package com.Coding.jpa;

import com.Coding.jpa.models.Author;
import com.Coding.jpa.repositories.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	//@Bean
	public CommandLineRunner commandLineRunner(AuthorRepository repository) {
		return args -> {
			var author = Author.builder()
					.firstName("Jack")
					.lastName("Doe")
					.age(41)
					.email("contact@gmail.com")
					.build();
			repository.save(author);

		};
	}

}
