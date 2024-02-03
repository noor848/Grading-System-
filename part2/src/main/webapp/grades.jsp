<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Grades</title>
</head>
<body>
<h2>Your Grades:</h2>
<ul>
    <% List<Float> grades = (List<Float>) request.getAttribute("grades");
        if (grades != null) {
            for (float grade : grades) { %>
    <li><%= grade %></li>
    <%     }
    } else { %>
    <li>No grades available</li>
    <% } %>
</ul>
</body>
</html>
