package com.cg.controller.api;


import com.cg.model.Class;
import com.cg.model.Course;
import com.cg.model.Student;
import com.cg.service.classes.IClassService;
import com.cg.service.course.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/classes")
public class ClassAPI {

    @Autowired
    private IClassService classService;

    @Autowired
    private ICourseService courseService;

    @GetMapping
    public ResponseEntity<Iterable<Class>> allClass() {
        Iterable<Class> classes = classService.findAll();
        if (((List) classes).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(classes, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Class> saveStudent(@RequestBody Class aClass) {
        if (aClass.getId() != null) {
            return new ResponseEntity<>(classService.save(aClass), HttpStatus.OK);
        }

        Optional<Course> course = courseService.findById(aClass.getCourse().getId());

        if (course.isPresent()) {
            aClass.setCourse(course.get());
            return new ResponseEntity<>(classService.save(aClass), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
