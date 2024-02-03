package main;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/grades")
public class GradeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        List<Float> grades = new ArrayList<>(); // List to store grades

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT grade FROM grade INNER JOIN students ON grade.studentId = students.Id WHERE username = ?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, username);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    float grade = resultSet.getFloat("grade");
                    System.out.println(grade);
                    grades.add(grade); // Add each grade to the list
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("grades", grades); // Set the list of grades as the attribute
        request.getRequestDispatcher("grades.jsp").forward(request, response);
    }
}
