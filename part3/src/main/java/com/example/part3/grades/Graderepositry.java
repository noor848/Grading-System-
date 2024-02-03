package com.example.part3.grades;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Graderepositry extends CrudRepository<Grade,Integer>{

    List<Grade> findByStudentId(Integer studentId);

//    void setGrade(String UserId, String courseId,double grade);
//    Grade save(Grade grade);

}
