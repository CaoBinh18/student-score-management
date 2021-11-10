package com.cg.repository;

import com.cg.model.AppClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<AppClass, Long> {
}
