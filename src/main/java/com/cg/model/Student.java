package com.cg.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

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

    @Column(name = "full_name", length = 50)
    private String fullName;
    private String gender;
    private Date dob;
    private String address;
    private Boolean status;

    @JsonIgnore
    @OneToMany(targetEntity = Score.class, mappedBy = "student")
    private Set<Score> scores;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private AppClass appClass;
}
