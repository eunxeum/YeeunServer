package net.skhu.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import net.skhu.entity.Student;
import net.skhu.repository.StudentRepository;

@Controller
@CrossOrigin
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("students")
    @ResponseBody
    public List<Student> students() {
        return studentRepository.findAll();
    }


    @GetMapping("student/list")
    public String list(Model model) {
        var students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "student/list";
    }
}

