package com.cg.controller;

import com.cg.model.Student;
import com.cg.service.classes.IClassService;
import com.cg.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @Autowired
    private IClassService classService;

    @GetMapping
    public ModelAndView listStudent() {
        ModelAndView modelAndView = new ModelAndView("/students/index");

//        Iterable<Student> students = studentService.findAll();

//        modelAndView.addObject("students", students);
        modelAndView.addObject("students", null);
        return modelAndView;
    }

//    @GetMapping("/create")
//    public ModelAndView showFormCreate() {
//        ModelAndView modelAndView = new ModelAndView("/students/create");
//        modelAndView.addObject("student", new Student());
//        modelAndView.addObject("classes", classService.findAll());
//        modelAndView.addObject("success", null);
//        return modelAndView;
//    }
//
//    @PostMapping(value = "/create", produces = "application/json;charset=UTF-8")
//    public ModelAndView save (@Validated @ModelAttribute("student") Student student,
//                              BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//        ModelAndView modelAndView = new ModelAndView();
//
//        if(bindingResult.hasFieldErrors()) {
//            modelAndView.setViewName("students/create");
//            modelAndView.addObject("classes", classService.findAll());
//            modelAndView.addObject("script", true);
//
//        } else {
//            if (studentService.existsByName(student.getFullName())) {
//                modelAndView.setViewName("city/create");
//                modelAndView.addObject("countries", classService.findAll());
//                modelAndView.addObject("error", "City already exists");
//
//            } else {
//                studentService.save(student);
//                redirectAttributes.addFlashAttribute("success", "Successfully added new student");
//                modelAndView.setViewName("redirect:/students");
//            }
//        }
//        return modelAndView;
//    }
}
