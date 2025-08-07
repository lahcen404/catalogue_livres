package com.challenge.livre.services;

import com.challenge.livre.models.Author;
import com.challenge.livre.repositories.AuthorRepo;

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

    public Author updateAuthor(Long id, Author authorDetails){
        Author existingAuthor = authorRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("author not found"));


        existingAuthor.setName(authorDetails.getName());
        existingAuthor.setBiography(authorDetails.getBiography());
        existingAuthor.setBooks(authorDetails.getBooks());

        return authorRepo.save(existingAuthor);
    }

}
