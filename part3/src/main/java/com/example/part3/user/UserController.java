package com.example.part3.user;
import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired private  UserService service;


        @PostMapping("/login")
        public String processLogin(@RequestParam("username") String username,
                                   @RequestParam("password") String password,
                                   Model model,  HttpSession session) {
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
            Optional<User> user= service.getUser(username, password);

            if (username != null && !username.isEmpty() && user.isPresent()) {
                if (username != null && username.equals("admin") && !username.isEmpty() && user.isPresent())
                    return "redirect:/portal";
                int userId = user.get().getId();
                session.setAttribute("userId",userId);
                return "redirect:/grades";

            } else {
                model.addAttribute("error", "Username is required.");
                return "Login";
            }
        }
        @GetMapping("/grading")
        public String showGradingPage() {
            // Logic to display grading page
            return "Grade";
        }
        @GetMapping("/portal")
        public String showPortalPage() {
            // Logic to display grading page
            return "portal";
        }

}
