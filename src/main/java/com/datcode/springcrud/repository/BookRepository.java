package com.datcode.springcrud.repository;

import com.datcode.springcrud.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
    
}
