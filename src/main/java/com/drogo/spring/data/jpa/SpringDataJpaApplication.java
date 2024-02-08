package com.drogo.spring.data.jpa;

import com.drogo.spring.data.jpa.entity.Author;
import com.drogo.spring.data.jpa.repository.AuthorRepository;
import com.drogo.spring.data.jpa.repository.VideoRepository;
import com.drogo.spring.data.jpa.specification.AuthorSpecification;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

@SpringBootApplication
public class SpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthorRepository authorRepository, VideoRepository videoRepository
    ) {
        return args -> {
            for (int i = 0; i < 50; i++) {
                Faker faker = new Faker();
                var author = Author.builder()
                        .firstName(faker.name().firstName())
                        .lastName(faker.name().lastName())
                        .age(faker.number().numberBetween(18, 60))
                        .email(faker.name().username() + "@testemail.com")
                        .build();
                authorRepository.save(author);
            }

            // selects Author with ID=1 and updates it
            var author = Author.builder()
                    .id(1)
                    .firstName("Suraj")
                    .lastName("Biradar")
                    .age(30)
                    .email("suraj.biradar@testemail.com")
                    .build();
           authorRepository.save(author);

            //update Author set age to 100 where id=2
            //authorRepository.updateAuthorAge(100, 2);

            //update age for all Authors
            //authorRepository.updateAllAuthorsAges(77);

            //authorRepository.findAllAgeByNamedQuery(30).forEach(System.out::println);

            Specification<Author> spec = Specification
                    .where(AuthorSpecification.hasAge(30))
                    //.and(AuthorSpecification.firstNameEqual("Suraj"))
                    .and(AuthorSpecification.firstNameLike("Su"));

            authorRepository.findAll(spec).forEach(System.out::println);



            
            /*var video= Video.builder()
                    .name("Complexity")
                    .length(10)
                    .build();
            Video savedVideo = videoRepository.save(video);*/

        };
    }

}
