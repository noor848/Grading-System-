<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Statistics</title>
</head>
<body>
<h2>Class Statistics:</h2>
<p>Class Average: <%= request.getAttribute("average") %></p>
<p>Highest Mark: <%= request.getAttribute("highest") %></p>
<p>Lowest Mark: <%= request.getAttribute("lowest") %></p>
</body>
</html>
