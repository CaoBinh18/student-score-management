package com.cg.service.student;

import com.cg.model.Student;
import com.cg.model.dto.IStudentDTO;
import com.cg.model.dto.StudentDTO;
import com.cg.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService implements IStudentService{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Iterable<StudentDTO> findAllDTO() {
//        return studentRepository.findAllDTO();
        return null;
    }

    @Override
    public Iterable<IStudentDTO> findAllIDTO() {
        return studentRepository.findAllIDTO();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void remove(Long id) {
        studentRepository.deleteById(id);
    }

   
}
