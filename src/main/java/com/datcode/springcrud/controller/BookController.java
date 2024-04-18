package com.datcode.springcrud.controller;

import com.datcode.springcrud.entity.Book;
import com.datcode.springcrud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    //Injection
    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public String createBook(@RequestBody Book book) {
        bookService.createBook(book);

        return "Success add new book";
    }

    @GetMapping
    public List<Book> getListBook() {
        return bookService.getListBook();
    }

    @GetMapping("/get")
    public Book getBookById(@RequestParam Integer id) {
        return bookService.getBookById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateBook(@PathVariable Integer id, @RequestBody Book book) {
        bookService.updateBook(id, book);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
