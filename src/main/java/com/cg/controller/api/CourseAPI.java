package com.cg.controller.api;


import com.cg.model.Class;
import com.cg.service.classes.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseAPI {
    @Autowired
    private IClassService classService;

    @GetMapping
    public ResponseEntity<Iterable<Class>> allClass() {
        Iterable<Class> classes = classService.findAll();
        if (((List) classes).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(classes, HttpStatus.OK);
    }
}


