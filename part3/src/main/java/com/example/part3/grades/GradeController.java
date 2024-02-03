package com.example.part3.grades;

import com.example.part3.course.CourseService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GradeController {

    @Autowired private GradeService service;
    @Autowired private CourseService courseService;


    @GetMapping("/grades")
    private String showGradeList(Model model, HttpSession session){
        int userId = (int) session.getAttribute("userId");
        List<Grade> gradeList = service.getGradesByStudentId(userId);
        List<String> courses = new ArrayList<>();

        System.out.println(gradeList.size());
        model.addAttribute("grades", gradeList);
//        model.addAttribute("courses", courses);
        return "Grade";
    }

    @PostMapping("/portal")
    public String setPortalPage(@RequestParam("UserId") String UserId,
                                @RequestParam("courseId") String courseId,
                                @RequestParam("grade") String grade,
                                Model model, HttpSession session) {
        float gradeVal = Float.parseFloat(grade);
        int courseVal = Integer.parseInt(courseId);
        int UserVal = Integer.parseInt(UserId);
        service.addGrade(UserVal, courseVal, gradeVal);
        return "redirect:/portal";
    }
}
