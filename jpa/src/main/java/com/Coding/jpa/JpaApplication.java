package com.Coding.jpa;

import com.Coding.jpa.models.Author;
import com.Coding.jpa.models.Video;
import com.Coding.jpa.repositories.AuthorRepository;
import com.Coding.jpa.repositories.VideoRepository;
import com.Coding.jpa.specification.AuthorSpecification;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthorRepository repository,
			VideoRepository videorepository
	) {
		return args -> {
			// ... any seeding/updating you need

			// now combine the fetch spec with your filters:
			Specification<Author> spec = Specification
					.where(AuthorSpecification.fetchCourses())          // fetch the courses eagerly
					.and(AuthorSpecification.hasAge(70))               // age == 70
					.and(AuthorSpecification.firstnameContains("el"));  // firstName contains "el"

			repository.findAll(spec)
					.forEach(System.out::println);               // no more LazyInitializationException!
		};
	}


	}


