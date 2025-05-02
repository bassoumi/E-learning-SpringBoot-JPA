package com.Coding.jpa.repositories;

import com.Coding.jpa.models.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> , JpaSpecificationExecutor<Author> {
    List<Author> findAllByFirstName(String fn);

    List<Author> findByNamedQuery(@Param("age") int age);
    @Modifying
    @Transactional
    void updateByNamedQuery(@Param("age") int age);

    //ignore case + containe the same letters
    List<Author> findAllByFirstNameContainingIgnoreCase(String fn);

    //start with + ignoreCase
    List<Author> findAllByFirstNameStartingWithIgnoreCase(String ln);

    //end With + ignoreCase
    List<Author> findAllByFirstNameEndingWithIgnoreCase(String ln);

    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age where a.id =:id")
    int updateAuthor(int age , int id);

    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age")
    void updateAuthors(int age);



}
