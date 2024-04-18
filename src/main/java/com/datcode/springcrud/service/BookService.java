package com.datcode.springcrud.service;

import com.datcode.springcrud.entity.Book;

import java.util.List;

public interface BookService {
    void createBook(Book book);

    List<Book> getListBook();

    Book getBookById(Integer id);

    void updateBook(Integer id, Book book);

    void deleteBook(Integer id);
}
