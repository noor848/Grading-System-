package com.example.part3.grades;

import jakarta.persistence.*;

@Entity
@Table(name = "grade")
public class Grade {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gradeid")
    private Integer gradeId;
    @Column(name = "studentid")
    private Integer studentId;
    @Column(name = "courseid")
    private Integer courseId;
    private  Float grade;

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public Integer getId() {
        return gradeId;
    }

    public void setId(Integer id) {
        gradeId = id;
    }
}
