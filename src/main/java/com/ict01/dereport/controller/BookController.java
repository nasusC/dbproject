package com.ict01.dereport.controller;

import com.ict01.dereport.util.PriceFormatter;
import com.ict01.dereport.ResourceNotFoundExeption;
import com.ict01.dereport.model.Book;
import com.ict01.dereport.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    // Service Constructor Dependency Injection
    private final BookService bookService;


    // http://localhost:8080/book/lists/
    // [1] 전체 책정보 조회
    @GetMapping("/lists")
    public String lists(Model model){

        // (1) 모든 책들을 가져온다.
        List<Book> books = bookService.lists();

        // (2) 가져온 Books Collection을 view에 전달한다.
        model.addAttribute("books",books);

        // http://localhost:8080/student/lists/WEB-INF/views/listStudents.jsp
        return "listBook";
    }


    // [2] 책정보 등록
    // [2-1] 책정보 등록 Form
    @GetMapping("/showForm") // URI
    public String showFormAdd(Model model){
        Book book = new Book(); // 새로운 객체 생성
        model.addAttribute("book",book); // 모델에 addAttribute를 통해 생성된 객체에서 받아온 정보를 view에 전달.
        // WEB-INF/views/bookForm.jsp 로 찾아간다.
        return "bookForm";
    }


    // [2-2] 학생정보 Action
    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book")Book book){
        bookService.saveBook(book);
        return "redirect:/book/lists";
    }

    // [3] 책정보 수정 (Update)
    // [3-1] 책정보 수정 Form
    @GetMapping("/updateForm")
    // @RequestParam : 클릭한 이벤트의 정보를 가져온다. View의 이름과 DB의 이름이 다를경우 꼭 써야한다.
    public String showFormUpdate(@RequestParam("bookId")int id, Model model)throws ResourceNotFoundExeption{
        Book book = bookService.getBook(id); // DB에서 id를 모두 다 가져와서 담은것
        model.addAttribute("book", book);
        return "updateForm";
    }
    // [3-2] 책정보 수정 Action
    @PostMapping("/updateBook")
    // @ModelAttribute 바뀐 object를 통채로 담는다.
    public String updateBook(@ModelAttribute("book")Book book){
        // 수정된 책 정보를 저장.
        bookService.saveBook(book);

        // 책 정보 수정 후, 학생 목록 화면으로 리다이렉트함.
        return "redirect:/book/lists";
    }


    // [4] 책정보 삭제
    @GetMapping("/delete")
    public String deleteBook(@RequestParam("bookId")int id)throws ResourceNotFoundExeption {
        bookService.deleteBook(id);
        return "redirect:/book/lists";
    }
}
