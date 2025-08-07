package com.challenge.livre.controllers;

import com.challenge.livre.models.Author;
import com.challenge.livre.services.AuthorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping()
    public Author createAuthor(Author author){
        return authorService.createAuthor(author);
    }

    @PutMapping("update/{id}")
    public Author updateAuthor(@PathVariable Long id , @RequestBody Author author){
        return authorService.updateAuthor(id,author);
    }
}
