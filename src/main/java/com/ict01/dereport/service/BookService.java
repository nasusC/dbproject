package com.ict01.dereport.service;

import com.ict01.dereport.ResourceNotFoundExeption;
import com.ict01.dereport.model.Book;

import java.util.List;

public interface BookService {

    //(1) 전체 책 조회 (Read)
    public List<Book> lists(); //lists <- 네이밍 룰

    //(2) 책 등록 (Create)
    public void saveBook(Book book);

    //(3) 책 정보 수정 (Update)
    public Book getBook(int id) throws ResourceNotFoundExeption;

    //(4) 책 정보 삭제 (Delete)
    public void deleteBook(int id) throws ResourceNotFoundExeption;

}
