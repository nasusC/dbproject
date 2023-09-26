package com.ict01.jpaproject01.controller;

import com.ict01.jpaproject01.ResourceNotFoundExeption;
import com.ict01.jpaproject01.model.Student;
import com.ict01.jpaproject01.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    // Service Constructor Dependency Injection
    private final StudentService studentService;

//    @Autowired
//    public StudentController(StudentService studentService) {
//        this.studentService = studentService;
//    }

    // http://localhost:8080/student/lists/
    // [1] 전체 학생정보 조회
    @GetMapping("/lists")
    public String lists(Model model){

        // (1) 모든 학생들을 가져온다.
        List<Student> students = studentService.lists();

        // (2) 가져온 Students Collection을 view에 전달한다.
        model.addAttribute("students",students);

        // http://localhost:8080/student/lists/WEB-INF/views/listStudents.jsp
        return "listStudent";
    }

//    [1]-2
//    @ResponseBody
//    public List<Student> list() throws ClassNotFoundException, SQLException {
//        List<Student> students = studentService.lists();
//
//        return students;
//    }



    // [2] 학생정보 등록
    // [2-1] 학생정보 등록 Form
    @GetMapping("/showForm") // URI
    public String showFormAdd(Model model){
        Student student = new Student(); // 새로운 객체 생성
        model.addAttribute("student",student); // 모델에 addAttribute를 통해 생성된 객체에서 받아온 정보를 view에 전달.
        // WEB-INF/views/studentForm.jsp 로 찾아간다.
        return "studentForm";
    }


    // [2-2] 학생정보 Action
    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student")Student student){
        studentService.saveStudent(student);
        return "redirect:/student/lists";
    }

    // [3]


    // [4] 학생정보 삭제
    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("studentId")int id)throws ResourceNotFoundExeption {
        studentService.deleteStudent(id);
        return "redirect:/student/lists";
    }
}
