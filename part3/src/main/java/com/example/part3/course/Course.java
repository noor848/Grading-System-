package com.example.part3.course;

import jakarta.persistence.*;
@Entity
@Table(name = "course")
public class Course {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courseid")
    private Integer courseId;
    @Column(name = "coursename")
    private String courseName;
    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

}
