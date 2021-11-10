package com.cg.repository;

import com.cg.model.Student;
import com.cg.model.dto.IStudentDTO;
import com.cg.model.dto.StudentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


//    @Query("SELECT NEW com.cg.model.dto.StudentDTO (s.id, s.gender, s.dob, s.status) FROM Student s")
//    Iterable<StudentDTO> findAllDTO();

    @Query("SELECT " +
            "s.id AS id, " +
            "s.fullName AS fullName, " +
            "s.gender AS gender, " +
            "s.dob AS dob, " +
            "s.appClass.name AS classes, " +
            "s.status AS status " +
            "FROM Student s"
    )
    Iterable<IStudentDTO> findAllIDTO();
}
