package com.example.part3.course;

import com.example.part3.grades.Grade;
import com.example.part3.grades.Graderepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private Courserepositry repo;

    public String getGradesByCourseId(Integer courseId) {
        return repo.findCourseByCourseId(courseId);
    }
}
