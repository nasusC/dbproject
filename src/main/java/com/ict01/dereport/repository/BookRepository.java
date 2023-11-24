package com.ict01.dereport.repository;

import com.ict01.dereport.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
