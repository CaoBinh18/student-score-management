package com.cg.repository;

import com.cg.model.Class;
import com.cg.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<Class, Long> {
}
