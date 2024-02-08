package com.drogo.spring.data.jpa.repository;

import com.drogo.spring.data.jpa.entity.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*  Repositories abstraction is to reduce the amount of boilerplate code
 *  needed to implement DAO (Data Access Object) to interact with the data stores */
@Repository
public interface AuthorRepository extends
        JpaRepository<Author, Integer>,
        JpaSpecificationExecutor<Author> {
    @Transactional
    @Modifying
    @Query("update Author a set a.age= :age where a.id= :id")
    int updateAuthorAge(int age, int id);

    @Transactional
    @Modifying
    @Query("update Author a set a.age= :age")
    void updateAllAuthorsAges(int age);

    @Transactional
    List<Author> findAllAgeByNamedQuery(@Param("age") int age);


    List<Author> findAllByFirstName(String firstName);

    List<Author> findAllByFirstNameIgnoreCase(String firstName);

    List<Author> findAllByFirstNameContainingIgnoreCase(String contains);

    List<Author> findAllByFirstNameStartsWithIgnoreCase(String startsWith);

    List<Author> findAllByFirstNameEndsWithIgnoreCase(String endsWith);

    List<Author> findAllByFirstNameInIgnoreCase(List<String> firstNames);

}
