package com.example.part3.course;

import com.example.part3.grades.Grade;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Courserepositry extends CrudRepository<Course,Integer> {

    String findCourseByCourseId(Integer courseId);

}