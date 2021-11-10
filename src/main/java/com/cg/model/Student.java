package com.cg.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fullname", length = 50)
    private String fullName;
    private String gender;
    private Date dob;
    private String address;
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private Class aClass;
}
