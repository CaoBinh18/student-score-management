package com.cg.model.dto;

import java.sql.Date;

public interface IStudentDTO {

    Long getId();
    String getFullName();
    String getGender();
    Date getDob();
    String getClasses();
    Boolean getStatus();
}
