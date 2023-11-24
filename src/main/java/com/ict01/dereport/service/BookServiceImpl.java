package com.ict01.dereport.service;

import com.ict01.dereport.ResourceNotFoundExeption;
import com.ict01.dereport.model.Book;
import com.ict01.dereport.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    // Constructor Dependency Injection
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> lists() {
        return bookRepository.findAll();
    }

    @Override
    public void saveBook(Book student) {
        bookRepository.save(student);

    }

    @Override
    public Book getBook(int id) throws ResourceNotFoundExeption {
        return bookRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundExeption(id));
    }

    @Override
    public void deleteBook(int id) throws ResourceNotFoundExeption {
        bookRepository.deleteById(id);

    }
}
