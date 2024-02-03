package com.example.part3.grades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    @Autowired private Graderepositry  repo;

    public List<Grade> listAll(){
        return (List<Grade>) repo.findAll();
    }
    public List<Grade> getGradesByStudentId(Integer studentId) {
        return repo.findByStudentId(studentId);
    }
    public void addGrade(int userId, int courseId, float grade) {
        Grade gradeEntry = new Grade();
        gradeEntry.setStudentId(userId);
        gradeEntry.setCourseId(courseId);
        gradeEntry.setGrade(grade);
        repo.save(gradeEntry);
    }
}
