package com.drogo.spring.data.jpa.repository;

import com.drogo.spring.data.jpa.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

/*  Repositories abstraction is to reduce the amount of boilerplate code
 *  needed to implement DAO (Data Access Object) to interact with the data stores */
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
