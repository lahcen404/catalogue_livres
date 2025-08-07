package com.challenge.livre.services;

import com.challenge.livre.models.Author;
import com.challenge.livre.models.Book;
import com.challenge.livre.repositories.AuthorRepo;
import com.challenge.livre.repositories.BookRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepo bookRepo;
    private final AuthorRepo authorRepo;

    public BookService(BookRepo bookRepo, AuthorRepo authorRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
    }

    public Book createBook(Book book){

        Long authorId = book.getAuthor().getId();

        Author author = authorRepo.findById(authorId)
                .orElseThrow(()-> new RuntimeException("author not found"));

        book.setAuthor(author);

        return bookRepo.save(book);
    }

    public Book updateBook(Long id , Book book){

        Book existingBook = bookRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("book not found"));

        existingBook.setTitle(book.getTitle());
        existingBook.setIsbn(book.getIsbn());
        existingBook.setAuthor(book.getAuthor());

        return bookRepo.save(existingBook);
    }

    public void deleteBook(Long id){
        bookRepo.deleteById(id);
    }

}
