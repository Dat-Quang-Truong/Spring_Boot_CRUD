package com.datcode.springcrud.service.impl;

import com.datcode.springcrud.entity.Book;
import com.datcode.springcrud.repository.BookRepository;
import com.datcode.springcrud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void createBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> getListBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Integer id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid book id" + id));
        return book;
    }

    @Override
    public void updateBook(Integer id, Book book) {
        // check id
        bookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid book id" + id));
        book.setId(id);
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Integer id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid book id" + id));
        bookRepository.delete(book);
    }
}
