package com.cg.service.classes;

import com.cg.model.AppClass;
import com.cg.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ClassService implements IClassService{

    @Autowired
    private ClassRepository classRepository;

    @Override
    public Iterable<AppClass> findAll() {
        return classRepository.findAll();
    }

    @Override
    public Optional<AppClass> findById(Long id) {
        return classRepository.findById(id);
    }

    @Override
    public AppClass save(AppClass aClass) {
        return classRepository.save(aClass);
    }

    @Override
    public void remove(Long id) {
        classRepository.deleteById(id);
    }
}
