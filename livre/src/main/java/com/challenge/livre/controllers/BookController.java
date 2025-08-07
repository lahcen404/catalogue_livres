package com.challenge.livre.controllers;

import com.challenge.livre.models.Book;
import com.challenge.livre.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/books")
public class BookController {


    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping()
    public Book createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }

    @PutMapping("update/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book){
        return bookService.updateBook(id,book);
    }

    @DeleteMapping("delete/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
    }
}
