package com.challenge.livre.services;

import com.challenge.livre.models.Author;
import com.challenge.livre.repositories.AuthorRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private final AuthorRepo authorRepo;

    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    public Author createAuthor(Author author){

        return authorRepo.save(author);
    }

}
