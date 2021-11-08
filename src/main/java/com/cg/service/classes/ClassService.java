package com.cg.service.classes;

import com.cg.model.Class;
import com.cg.model.Student;
import com.cg.repository.ClassRepository;
import com.cg.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ClassService implements IClassService{

    @Autowired
    private ClassRepository classRepository;

    @Override
    public Iterable<Class> findAll() {
        return classRepository.findAll();
    }

    @Override
    public Optional<Class> findById(Long id) {
        return classRepository.findById(id);
    }

    @Override
    public Class save(Class aClass) {
        return classRepository.save(aClass);
    }

    @Override
    public void remove(Long id) {
        classRepository.deleteById(id);
    }
}
