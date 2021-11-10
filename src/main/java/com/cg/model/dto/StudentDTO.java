package com.cg.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private Long id;
    private String fullName;
    private String gender;
    private Date dob;
    private Boolean status;

    public StudentDTO(Long id, String gender, Date dob, Boolean status) {
        this.id = id;
        this.gender = gender;
        this.dob = dob;
        this.status = status;
    }


}
