package com.cg.service.student;

import com.cg.model.Student;
import com.cg.model.dto.IStudentDTO;
import com.cg.model.dto.StudentDTO;
import com.cg.service.IGeneralService;

public interface IStudentService extends IGeneralService<Student> {
    public Iterable<StudentDTO> findAllDTO();

    public Iterable<IStudentDTO> findAllIDTO();
}
