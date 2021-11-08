package com.cg.controller.api;

import com.cg.model.Class;
import com.cg.model.Course;
import com.cg.model.Student;
import com.cg.service.classes.IClassService;
import com.cg.service.course.ICourseService;
import com.cg.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/students")
public class StudentAPI {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private IClassService classService;

    @GetMapping
    public ResponseEntity<Iterable<Student>> allCustomers() {
        Iterable<Student> students = studentService.findAll();
        if (((List) students).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<Student> getId(@PathVariable Long id) {
        Optional<Student> studentOptional = studentService.findById(id);
        if (studentOptional.isPresent()) {
            return new ResponseEntity<>(studentOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
     //   if (student.getId() != null) {
            return new ResponseEntity<>(studentService.save(student), HttpStatus.OK);
     //   }

      //  Optional<Class> aClass = classService.findById(student.getAClass().getId());

       // if (aClass.isPresent()) {
           // student.setAClass(aClass.get());
       //     return new ResponseEntity<>(studentService.save(student), HttpStatus.CREATED);
       // } else {
       //     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        //}
    }

    @PutMapping()
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Optional<Student> studentOptional = studentService.findById(id);
        if (!studentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        student.setId(studentOptional.get().getId());
        return new ResponseEntity<>(studentService.save(student), HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<Student> deleteStudent(@RequestBody Map<String, String> json) {
        Long id = Long.valueOf(json.get("id"));
        Optional<Student> studentOptional = studentService.findById(id);
        if (!studentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studentService.remove(id);
        return new ResponseEntity<>(studentOptional.get(), HttpStatus.NO_CONTENT);
    }

}
