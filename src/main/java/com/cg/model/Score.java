package com.cg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "scores")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "stu_id",referencedColumnName = "id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "sub_id",referencedColumnName = "id")
    private Subject subject;

    @Column(name = "regular_score")
    private int regularScore;

    @Column(name = "midterm_score")
    private int midtermScore;

    @Column(name = "semester_score")
    private int semesterScore;


}
