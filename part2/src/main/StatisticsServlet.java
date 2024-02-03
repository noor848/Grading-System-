package main;
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

@WebServlet("/statistics")
public class StatisticsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double average = 0;
        int highest = 0;
        int lowest = 0;

        try (Connection conn = DatabaseConnection.getConnection()) {
            // Compute average grade
            String avgSql = "SELECT AVG(grade) AS average FROM grade";
            try (PreparedStatement avgStatement = conn.prepareStatement(avgSql)) {
                ResultSet avgResultSet = avgStatement.executeQuery();
                if (avgResultSet.next()) {
                    average = avgResultSet.getDouble("average");
                }
            }

            // Retrieve highest grade
            String maxSql = "SELECT MAX(grade) AS highest FROM grade";
            try (PreparedStatement maxStatement = conn.prepareStatement(maxSql)) {
                ResultSet maxResultSet = maxStatement.executeQuery();
                if (maxResultSet.next()) {
                    highest = maxResultSet.getInt("highest");
                }
            }

            // Retrieve lowest grade
            String minSql = "SELECT MIN(grade) AS lowest FROM grade";
            try (PreparedStatement minStatement = conn.prepareStatement(minSql)) {
                ResultSet minResultSet = minStatement.executeQuery();
                if (minResultSet.next()) {
                    lowest = minResultSet.getInt("lowest");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("average", average);
        request.setAttribute("highest", highest);
        request.setAttribute("lowest", lowest);
        request.getRequestDispatcher("statistics.jsp").forward(request, response);
    }
}
