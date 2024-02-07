package com.drogo.spring.data.jpa;

import com.drogo.spring.data.jpa.entity.Author;
import com.drogo.spring.data.jpa.repository.AuthorRepository;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

    //@Bean
    public CommandLineRunner commandLineRunner(AuthorRepository authorRepository) {
        return args -> {
            var author = Author.builder()
                    .firstName("Suraj")
                    .lastName("Biradar")
                    .age(30)
                    .email("suraj.biradar@email.com")
                    .build();
            authorRepository.save(author);

        };
    }

}
