package main;

import main.DatabaseConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            // Handle POST requests
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Connection conn = null;

            try {
                conn = DatabaseConnection.getConnection();
                if (conn != null) {
                    String sql = "SELECT * FROM students WHERE username = ? AND password = ?";
                    try (PreparedStatement statement = conn.prepareStatement(sql)) {
                        statement.setString(1, username);
//                        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
//                        statement.setString(2, hashedPassword);
                        statement.setString(2, password);
                        ResultSet resultSet = statement.executeQuery();

                        if (resultSet.next()) {
                            HttpSession session = request.getSession();
                            session.setAttribute("username", username);
                            if (username.trim().equalsIgnoreCase("admin"))
                                response.sendRedirect("statistics.jsp"); // Redirect to /statistics
                           else response.sendRedirect("grades.jsp");
                            return;
                        }
                    }
                }
                // Redirect if login fails or if there's an issue with the database connection
                response.sendRedirect("login.jsp?error=1");
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendRedirect("login.jsp?error=2");
            } finally {
//                DatabaseConnection.closeConnection(conn); // Close the connection in the finally block
            }
        }

    }

