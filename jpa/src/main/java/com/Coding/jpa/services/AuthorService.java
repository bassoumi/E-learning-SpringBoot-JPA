package com.Coding.jpa.services;


import com.Coding.jpa.models.Author;
import com.Coding.jpa.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthorsByFirstName(String firstName) {
        return  authorRepository.findAllByFirstName(firstName);
    }

    public List<Author> getAllAuthorsByFirstNameStartWidth(String fnStart) {
        return authorRepository.findAllByFirstNameStartingWithIgnoreCase(fnStart);
    }


}
