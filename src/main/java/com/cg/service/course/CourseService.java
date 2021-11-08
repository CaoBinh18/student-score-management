package com.cg.service.course;

import com.cg.model.Course;
import com.cg.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CourseService implements ICourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Iterable<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void remove(Long id) {
        courseRepository.deleteById(id);
    }
}
